package chess.robot.wanglei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chess.robot.IRobot;
import chess.robot.Position;

public class Robot implements IRobot, ChessConfig {
	// 棋盘棋子的摆放情况：0无子，1自己，－1对手
	private int[][] isAvail = new int[CHESS_COLUMN][CHESS_ROW];

	// 保存每一步的落子情况
	private List<Position> chessPositonList = new ArrayList<Position>();

	// 定义一个二维数组，保存各个点的权值
	private int[][] weightArray = new int[CHESS_COLUMN][CHESS_ROW];

	// 设置不同落子情况和相应权值的数组
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	
	// 是否为第一步
	private boolean isFirstStep = true;
	
	static {
		// 被堵住
		map.put("01", 25);// 眠1连
		map.put("02", 22);// 眠1连
		map.put("001", 17);// 眠1连
		map.put("002", 12);// 眠1连
		map.put("0001", 17);// 眠1连
		map.put("0002", 12);// 眠1连

		map.put("0102", 25);// 眠1连，15
		map.put("0201", 22);// 眠1连，10
		map.put("0012", 15);// 眠1连，15
		map.put("0021", 10);// 眠1连，10
		map.put("01002", 25);// 眠1连，15
		map.put("02001", 22);// 眠1连，10
		map.put("00102", 17);// 眠1连，15
		map.put("00201", 12);// 眠1连，10
		map.put("00012", 15);// 眠1连，15
		map.put("00021", 10);// 眠1连，10

		map.put("01000", 25);// 活1连，15
		map.put("02000", 22);// 活1连，10
		map.put("00100", 19);// 活1连，15
		map.put("00200", 14);// 活1连，10
		map.put("00010", 17);// 活1连，15
		map.put("00020", 12);// 活1连，10
		map.put("00001", 15);// 活1连，15
		map.put("00002", 10);// 活1连，10

		// 被墙堵住
		map.put("0101", 65);// 眠2连，40
		map.put("0202", 60);// 眠2连，30
		map.put("0110", 80);// 眠2连，40
		map.put("0220", 76);// 眠2连，30
		map.put("011", 80);// 眠2连，40
		map.put("022", 76);// 眠2连，30
		map.put("0011", 65);// 眠2连，40
		map.put("0022", 60);// 眠2连，30

		map.put("01012", 65);// 眠2连，40
		map.put("02021", 60);// 眠2连，30
		map.put("01102", 80);// 眠2连，40
		map.put("02201", 76);// 眠2连，30
		map.put("01120", 80);// 眠2连，40
		map.put("02210", 76);// 眠2连，30
		map.put("00112", 65);// 眠2连，40
		map.put("00221", 60);// 眠2连，30

		map.put("01100", 80);// 活2连，40
		map.put("02200", 76);// 活2连，30
		map.put("01010", 75);// 活2连，40
		map.put("02020", 70);// 活2连，30
		map.put("00110", 75);// 活2连，40
		map.put("00220", 70);// 活2连，30
		map.put("00011", 75);// 活2连，40
		map.put("00022", 70);// 活2连，30

		// 被堵住
		map.put("0111", 150);// 眠3连，100
		map.put("0222", 140);// 眠3连，80

		map.put("01112", 150);// 眠3连，100
		map.put("02221", 140);// 眠3连，80

		map.put("01110", 1100);// 活3连
		map.put("02220", 1050);// 活3连
		map.put("01101", 1000);// 活3连，130
		map.put("02202", 800);// 活3连，110
		map.put("01011", 1000);// 活3连，130
		map.put("02022", 800);// 活3连，110

		map.put("01111", 3000);// 4连，300
		map.put("02222", 3500);// 4连，280
	}

	@Override
	public String playerName() {
		return "王磊";
	}

	@Override
	public void play(boolean isBlack) {
	}

	// AI联合算法
	public Integer unionWeight(Integer a, Integer b) {
		// 必须要先判断a,b两个数值是不是null
		if ((a == null) || (b == null))
			return 0;
		// 一一:101/202
		else if ((a >= 22) && (a <= 25) && (b >= 22) && (b <= 25))
			return 60;
		// 一二、二一:1011/2022
		else if (((a >= 22) && (a <= 25) && (b >= 76) && (b <= 80))
				|| ((a >= 76) && (a <= 80) && (b >= 22) && (b <= 25)))
			return 800;
		// 一三、三一、二二:10111/20222
		else if (((a >= 10) && (a <= 25) && (b >= 1050) && (b <= 1100))
				|| ((a >= 1050) && (a <= 1100) && (b >= 10) && (b <= 25))
				|| ((a >= 76) && (a <= 80) && (b >= 76) && (b <= 80)))
			return 3000;
		// 眠三连和眠一连。一三、三一
		else if (((a >= 22) && (a <= 25) && (b >= 140) && (b <= 150))
				|| ((a >= 140) && (a <= 150) && (b >= 22) && (b <= 25)))
			return 3000;
		// 二三、三二:110111
		else if (((a >= 76) && (a <= 80) && (b >= 1050) && (b <= 1100))
				|| ((a >= 1050) && (a <= 1100) && (b >= 76) && (b <= 80)))
			return 3000;
		else
			return 0;
	}

	@Override
	public Position nextStep() {
		// 计算位置的权值
		if (!isFirstStep) {
			evaluate();
		}
		
		// 取出最大的权值
		Position bestPosition = createPosition(9, 9);
		if (!isFirstStep) {
			bestPosition = getBestPosition();
		}
		
		// 设置当前位置已经有棋子了，棋子为自己
		this.chessPositonList.add(bestPosition);
		this.isAvail[bestPosition.x][bestPosition.y] = SELF;

		// 落子以后重置权值数组weightArray
		for (int i = 0; i < CHESS_COLUMN; i++)
			for (int j = 0; j < CHESS_ROW; j++)
				this.weightArray[i][j] = 0;

		if (isFirstStep) {
			isFirstStep = false;
		}
		return bestPosition;
	}

	private Position getBestPosition() {
		int AIi = 0, AIj = 0;
		int weightmax = 0;
		for (int i = 0; i < CHESS_ROW; i++) {
			for (int j = 0; j < CHESS_COLUMN; j++) {
				if (weightmax < this.weightArray[i][j]) {
					weightmax = this.weightArray[i][j];
					AIi = i;
					AIj = j;
				}
			}
		}

		// 设置当前位置已经有棋子了，棋子为自己
		Position bestPosition = createPosition(AIi, AIj);
		return bestPosition;
	}

	private void evaluate() {
		for (int i = 0; i < this.isAvail.length; i++) {
			for (int j = 0; j < this.isAvail[i].length; j++) {
				// 首先判断当前位置是否为空
				if (isAvail[i][j] == NO_POINT) {
					// 往左延伸
					String ConnectType = "0";
					int jmin = Math.max(0, j - 4);
					for (int positionj = j - 1; positionj >= jmin; positionj--) {
						// 依次加上前面的棋子
						ConnectType = ConnectType + this.isAvail[i][positionj];
					}

					// 从数组中取出相应的权值，加到权值数组的当前位置中
					Integer valueleft = map.get(ConnectType);
					if (valueleft != null)
						this.weightArray[i][j] += valueleft;

					// 往右延伸
					ConnectType = "0";
					int jmax = Math.min(14, j + 4);
					for (int positionj = j + 1; positionj <= jmax; positionj++) {
						// 依次加上前面的棋子
						ConnectType = ConnectType + this.isAvail[i][positionj];
					}
					// 从数组中取出相应的权值，加到权值数组的当前位置中
					Integer valueright = map.get(ConnectType);
					if (valueright != null)
						this.weightArray[i][j] += valueright;

					// 联合判断，判断行
					this.weightArray[i][j] += unionWeight(valueleft, valueright);

					// 往上延伸
					ConnectType = "0";
					int imin = Math.max(0, i - 4);
					for (int positioni = i - 1; positioni >= imin; positioni--) {
						// 依次加上前面的棋子
						ConnectType = ConnectType + this.isAvail[positioni][j];
					}
					// 从数组中取出相应的权值，加到权值数组的当前位置中
					Integer valueup = map.get(ConnectType);
					if (valueup != null)
						this.weightArray[i][j] += valueup;

					// 往下延伸
					ConnectType = "0";
					int imax = Math.min(14, i + 4);
					for (int positioni = i + 1; positioni <= imax; positioni++) {
						// 依次加上前面的棋子
						ConnectType = ConnectType + this.isAvail[positioni][j];
					}
					// 从数组中取出相应的权值，加到权值数组的当前位置中
					Integer valuedown = map.get(ConnectType);
					if (valuedown != null)
						this.weightArray[i][j] += valuedown;

					// 联合判断，判断列
					this.weightArray[i][j] += unionWeight(valueup, valuedown);

					// 往左上方延伸,i,j,都减去相同的数
					ConnectType = "0";
					for (int position = -1; position >= -4; position--) {
						if ((i + position >= 0) && (i + position <= 14)
								&& (j + position >= 0)
								&& (j + position <= 14))
							ConnectType =
									ConnectType
											+ this.isAvail[i + position][j + position];
					}
					// 从数组中取出相应的权值，加到权值数组的当前位置
					Integer valueLeftUp = map.get(ConnectType);
					if (valueLeftUp != null)
						this.weightArray[i][j] += valueLeftUp;

					// 往右下方延伸,i,j,都加上相同的数
					ConnectType = "0";
					for (int position = 1; position <= 4; position++) {
						if ((i + position >= 0) && (i + position <= 14)
								&& (j + position >= 0)
								&& (j + position <= 14))
							ConnectType =
									ConnectType
											+ this.isAvail[i + position][j + position];
					}
					// 从数组中取出相应的权值，加到权值数组的当前位置
					Integer valueRightDown = map.get(ConnectType);
					if (valueRightDown != null)
						this.weightArray[i][j] += valueRightDown;

					// 联合判断，判断行
					this.weightArray[i][j] += unionWeight(valueLeftUp, valueRightDown);

					// 往左下方延伸,i加,j减
					ConnectType = "0";
					for (int position = 1; position <= 4; position++) {
						if ((i + position >= 0) && (i + position <= 14)
								&& (j - position >= 0)
								&& (j - position <= 14))
							ConnectType =
									ConnectType
											+ this.isAvail[i + position][j - position];
					}
					// 从数组中取出相应的权值，加到权值数组的当前位置
					Integer valueLeftDown = map.get(ConnectType);
					if (valueLeftDown != null)
						this.weightArray[i][j] += valueLeftDown;

					// 往右上方延伸,i减,j加
					ConnectType = "0";
					for (int position = 1; position <= 4; position++) {
						if ((i - position >= 0) && (i - position <= 14)
								&& (j + position >= 0)
								&& (j + position <= 14))
							ConnectType =
									ConnectType
											+ this.isAvail[i - position][j + position];
					}
					// 从数组中取出相应的权值，加到权值数组的当前位置
					Integer valueRightUp = map.get(ConnectType);
					if (valueRightUp != null)
						this.weightArray[i][j] += valueRightUp;

					// 联合判断，判断行
					this.weightArray[i][j] += unionWeight(valueLeftDown, valueRightUp);
				}
			}
		}
	}

	@Override
	public void putChess(Position pos) {
		if (isFirstStep) {
			isFirstStep = false;
		}
		// 记录下棋位置
		this.isAvail[pos.x][pos.y] = OPPONENT;

		// 保存落子
		this.chessPositonList.add(pos);

	}

	// private static boolean containsPosition(Collection<Position> positions,
	// Position position) {
	// Iterator<Position> iterator = positions.iterator();
	// while (iterator.hasNext()) {
	// Position currentPosition = iterator.next();
	// if (currentPosition.x == position.x && currentPosition.y == position.y) {
	// return true;
	// }
	// }
	//
	// return false;
	// }

	private Position createPosition(int x, int y) {
		Position position = new Position();
		position.setX(x);
		position.setY(y);
		return position;
	}
}
