package chess.runner;

import chess.robot.IRobot;
import chess.robot.Position;
import chess.view.ChessBoard;
import chess.view.MainWnd;

/**
 * 运行器
 * @author Administrator
 *
 */
public class ChessRunner {
	/**
	 * 每一步的暂停时间
	 */
	private static int PAUSETIME_PERSTEP = 1000;
	/**
	 * 每一步的超时时间
	 */
	private static int TIMEOUT_PERSTEP = 15000;
	/**
	 * 主窗口
	 */
	private MainWnd mainWnd;
	/**
	 * 棋盘
	 */
	private ChessBoard chessBoard;
	/**
	 * 机器人线程
	 */
	private Thread robotThread;
	/**
	 * 游戏中标志
	 */
	private boolean inGaming = false;
	/**
	 * 黑机器人
	 */
	private IRobot blackRobot;
	/**
	 * 白机器人
	 */
	private IRobot whiteRobot;
	/**
	 * 下一手位置
	 */
	private Position nextStepPos;
	/**
	 * 思考完成标志
	 */
	boolean nextStepFinished;

	/**
	 * 构造函数
	 * @param board
	 */
	public ChessRunner(MainWnd mainWnd, ChessBoard board) {
		this.mainWnd = mainWnd;
		this.chessBoard = board;
	}
	
	/**
	 * 开始游戏
	 * @param blackRobot
	 * @param whiteRobot
	 */
	public boolean start(IRobot blackRobot, IRobot whiteRobot) {
		if(!inGaming) {
			//设置游戏中标志
			inGaming = true;
			
			//清空棋盘
			chessBoard.reset();
			
			//保存机器人
			this.blackRobot = blackRobot;
			this.whiteRobot = whiteRobot;
			
			//通知机器人开始比赛
			blackRobot.play(true);
			whiteRobot.play(false);
			
			//启动调度线程
			new Thread(()->{
				playGame();
			}).start();
			
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查游戏结果是否已确定
	 * @lastChessManPos 最后一手的位置
	 * @return
	 */
	private PlayResult checkPlayResult(Position lastChessManPos) {
		//4个方向横竖的递增量
		int[] dxs = new int[] {1, 0, 1, 1};
		int[] dys = new int[] {0, 1, 1, -1};
		
		//检查最后一手4个方向是否存在5个及以上的同色棋子
		for(int i = 0; i < dxs.length; i++) {
			int x = lastChessManPos.x;
			int y = lastChessManPos.y;
			
			//向左找到最后一个同色棋子的位置
			while(x > 0 && x < 18 && y > 0 && y < 18) {
				if(chessBoard.getChessmans()[(y - dys[i]) * 19 + (x - dxs[i])] != 
						chessBoard.getChessmans()[lastChessManPos.y * 19 + lastChessManPos.x]) {
					break;
				} else {
					x -= dxs[i];
					y -= dys[i];
				}
			}
			
			//向右统计是否够5个
			int count = 0;
			while(x >= 0 && x < 19 && y >= 0 && y < 19) {
				if(chessBoard.getChessmans()[y * 19 + x] != 
						chessBoard.getChessmans()[lastChessManPos.y * 19 + lastChessManPos.x]) {
					break;
				} else {
					x += dxs[i];
					y += dys[i];
					
					count++;
					if(count >= 5) {
						if(chessBoard.getChessmans()[lastChessManPos.y * 19 + lastChessManPos.x] == Chessman.Black) {
							return PlayResult.BlackWin;
						} else {
							return PlayResult.WhiteWin;
						}
					}
				}
			}
		}
		
		//检查是否还有空位
		for(int r = 0; r < 19; r++) {
			for(int c = 0; c < 19; c++) {
				if(chessBoard.getChessmans()[r * 19 + c] == Chessman.Empty) {
					return PlayResult.Dubious;
				}
			}
		}
		
		return PlayResult.Tied;
	}

	/**
	 * 检查指定位置是否可下子
	 * @param pos
	 * @return
	 */
	private boolean isEmptyPos(Position pos) {
		return chessBoard.getChessmans()[pos.y * 19 + pos.x] == Chessman.Empty;
	}
	
	/**
	 * 延时
	 * @param ms
	 */
	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 启动机器人
	 * @param isBlack
	 */
	private void startRobot(boolean isBlack) {
		nextStepPos = null;
		nextStepFinished = false;
		
		robotThread = new Thread(()-> {
			try {
				if(isBlack) {
					nextStepPos = blackRobot.nextStep();
				} else {
					nextStepPos = whiteRobot.nextStep();
				}
				
				if(nextStepPos.getX() < 0 || nextStepPos.getX() >= 19 ||
						nextStepPos.getY() < 0 || nextStepPos.getY() >= 19) {
					nextStepPos = null;
				} else if(!isEmptyPos(nextStepPos)) {
					nextStepPos = null;
				}
				
				nextStepFinished = true;
			} catch (Exception e) {
				e.printStackTrace();
				nextStepPos = null;
				nextStepFinished = true;
			}
		});
		
		robotThread.start();
	}
	
	/**
	 * 强迫杀死机器人线程
	 */
	@SuppressWarnings("deprecation")
	private void killRobotThread() {
		if(robotThread != null) {
			try {
				robotThread.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 进行游戏
	 */
	private void playGame() {
		//游戏结果
		PlayResult result = PlayResult.Tied;
		
		//双方用时
		int blackTime = 0;
		int whiteTime = 0;

		//下一步开始时的累加用时
		int nextStepTime = 0;
		
		//下一首开始思考的时间
		long nextStepBeginTime = 0;

		//状态
		PlayState state = PlayState.Idle;
		
		//交替对弈
		while(state != PlayState.PlayEnd) {
			//取得当前时间
			long curTime = System.currentTimeMillis();
			
			//状态处理
			switch(state) {
			case Idle:
				//启动黑方
				startRobot(true);
				nextStepBeginTime = System.currentTimeMillis();
				nextStepTime = blackTime;
				state = PlayState.BlackThinking;
				break;
			case BlackThinking:
				//累加计时
				blackTime = nextStepTime + (int)((curTime - nextStepBeginTime) / 1000);
				
				//更新计时
				chessBoard.setPlayerTime(TimerMode.BlackTimer, blackTime);
				
				//下一步思考完成
				if(nextStepFinished) {
					if(nextStepPos == null) {
						state = PlayState.PlayEnd;
						result = PlayResult.WhiteWin;
					} else {
						//落子
						chessBoard.putChessman(nextStepPos.y, nextStepPos.x, Chessman.Black);
						whiteRobot.putChess(nextStepPos);
						
						//延时1秒
						sleep(PAUSETIME_PERSTEP);
						
						//胜负检查
						result = checkPlayResult(nextStepPos);
						if(result == PlayResult.Dubious) {
							//启动白棋
							startRobot(false);
							nextStepBeginTime = System.currentTimeMillis();
							nextStepTime = whiteTime;
							state = PlayState.WhiteThinking;
						} else {
							state = PlayState.PlayEnd;
						}
					}
				} else {
					//超时检查
					if(curTime - nextStepBeginTime >= TIMEOUT_PERSTEP) {
						killRobotThread();
						state = PlayState.PlayEnd;
						result = PlayResult.WhiteWin;
					} else {
						sleep(1);
					}
				}
				break;
			case WhiteThinking:
				//累加计时
				whiteTime = nextStepTime + (int)((curTime - nextStepBeginTime) / 1000);
				
				//更新计时
				chessBoard.setPlayerTime(TimerMode.WhiteTimer, whiteTime);
				
				//下一步思考完成
				if(nextStepFinished) {
					if(nextStepPos == null) {
						state = PlayState.PlayEnd;
						result = PlayResult.BlackWin;
					} else {
						//落子
						chessBoard.putChessman(nextStepPos.y, nextStepPos.x, Chessman.White);
						blackRobot.putChess(nextStepPos);
						
						//延时1秒
						sleep(PAUSETIME_PERSTEP);
						
						result = checkPlayResult(nextStepPos);
						if(result == PlayResult.Dubious) {
							//启动黑棋
							startRobot(true);
							nextStepBeginTime = System.currentTimeMillis();
							nextStepTime = blackTime;
							state = PlayState.BlackThinking;
						} else {
							state = PlayState.PlayEnd;
						}
					}
				} else {
					//超时检查
					if(curTime - nextStepBeginTime >= TIMEOUT_PERSTEP) {
						killRobotThread();
						state = PlayState.PlayEnd;
						result = PlayResult.BlackWin;
					} else {
						sleep(10);
					}
				}
				break;
			default:
				// Nothing to do
				break;
			}
		}
		
		//通知主窗口游戏结果
		inGaming = false;
		mainWnd.playEnd(result);
	}
	
	/**
	 * 游戏运行状态
	 * @author Administrator
	 *
	 */
	private enum PlayState {
		/**
		 * 空闲
		 */
		Idle,
		/**
		 * 黑方思考中
		 */
		BlackThinking,
		/**
		 * 白方思考中
		 */
		WhiteThinking,
		/**
		 * 结束
		 */
		PlayEnd
	}
}
