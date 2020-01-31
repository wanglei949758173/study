package chess.robot.human;

import java.awt.event.MouseEvent;

import chess.robot.IRobot;
import chess.robot.Position;

public class Human implements  IRobot {

	private int boardSize = 19;
	private int SPACE_WIDTH;
	private int[][] chessBoard; // 
	private boolean isBlack = true;// 
	private String name = "人工选手";
	private Position point;

	/**
	 * 获取参数选手的名字
	 * 
	 * @return 选手名字
	 */
	public String playerName() {
		return this.name;
	}

	/**
	 * 开始游戏
	 * 
	 * @param isBlack
	 *            是否持黑子
	 */
	public void play(boolean isBlack) {
		this.point = null;
		this.isBlack = isBlack;
		this.chessBoard = new int[this.boardSize][this.boardSize];

		// 初始化棋盘
		for (int i = 0; i < this.boardSize; i++) {
			for (int j = 0; j < this.boardSize; j++) {
				this.chessBoard[i][j] = 0;
			}
		}
	}

	/**
	 * 下一步
	 * 
	 * @return
	 */
	public Position nextStep() {
		return this.getChess();
	}

	/**
	 * 对手落子位置
	 * 
	 * @param pos
	 */
	public void putChess(Position pos) {
		this.chessBoard[pos.getY()][pos.getX()] = isBlack ? -1 : 1;
		this.point = null;
	}

	public Human(int space_width) {
		this.SPACE_WIDTH = space_width;
	}
	
	public Human() {
		this.SPACE_WIDTH = 39;
	}

	private Position getChess() {
		while (this.point == null) {
			if (this.point != null) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.chessBoard[this.point.getY()][this.point.getX()] = isBlack ? -1 : 1;
		return this.point;
	}

	public void mouseClicked(MouseEvent e) {

		int x = this.round(e.getX()), y = this.round(e.getY());
		if (x >= SPACE_WIDTH && x <= SPACE_WIDTH * this.boardSize && y >= SPACE_WIDTH
				&& y <= SPACE_WIDTH * this.boardSize && this.chessBoard[y / SPACE_WIDTH - 1][x / SPACE_WIDTH - 1] == 0
				&& this.point == null) {
			
			this.point = new Position();
			point.setX(x / SPACE_WIDTH - 1);
			point.setY( y / SPACE_WIDTH - 1);
		}
	}


	public int round(int x) {
		return (x % SPACE_WIDTH < SPACE_WIDTH / 2) ? x / SPACE_WIDTH * SPACE_WIDTH
				: x / SPACE_WIDTH * SPACE_WIDTH + SPACE_WIDTH;
	}
}
