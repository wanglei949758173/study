package chess.robot.wanglei;

import java.util.HashSet;
import java.util.Iterator;

import chess.robot.IRobot;
import chess.robot.Position;

public class Robot implements IRobot {
	// 无子
	// private static final int NO_POINT = 0;

	// 我的子
	private static final int MY_POINT = 1;

	// 对手的子
	private static final int OTHER_POINT = -1;

	// 棋盘大小
	private static final int CHESS_BOARD_SIZE = 19; // 棋盘大小

	// 棋盘棋子的摆放情况：0无子，1自己，－1对手
	public static int[][] chessBoard = new int[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE];

	// 自己可以落的所有点
	private static HashSet<Position> myOptionPoints = new HashSet<Position>();

	private boolean chessBoardIsEmpty = true;

	static {
		// 初始化自己可以落的所有点
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				Position myOptionPosition = new Position();
				myOptionPosition.setX(i);
				myOptionPosition.setY(j);
				myOptionPoints.add(myOptionPosition);
			}
		}
	}

	@Override
	public String playerName() {
		return "王磊";
	}

	@Override
	public void play(boolean isBlack) {
	}

	@Override
	public Position nextStep() {
		Position result = new Position();
		// 自己先走
		if (chessBoardIsEmpty) {
			chessBoard[9][9] = 1;
			chessBoardIsEmpty = false;
			result.setX(9);
			result.setY(9);
			Iterator<Position> iterator = myOptionPoints.iterator();
			while (iterator.hasNext()) {
				Position currenPoint = iterator.next();
				if (currenPoint.x == result.x && currenPoint.y == result.y) {
					iterator.remove();
				}
			}
			return result;
		}
		// 棋盘不为空
		result = getBestPoint();

		// 设置棋盘
		chessBoard[result.x][result.y] = MY_POINT;

		// 从可选的点中移除此点
		Iterator<Position> iterator = myOptionPoints.iterator();
		while (iterator.hasNext()) {
			Position currenPoint = iterator.next();
			if (currenPoint.x == result.x && currenPoint.y == result.y) {
				iterator.remove();
			}
		}
		return result;
	}

	private Position getBestPoint() {
		// 遍历所有可选择的点，然后选择中间的点
		Position bestPosition = new Position();
		//
		int x = 999;
		int y = 999;
		for (Position point : myOptionPoints) {
			int curX = point.x;
			int curY = point.y;
			int xN = Math.abs(curX - 9);
			int yN = Math.abs(curY - 9);
			if ((xN + yN) < (x + y)) {
				x = xN;
				y = yN;
				bestPosition.setX(point.x);
				bestPosition.setY(point.y);
			}
		}
		return bestPosition;
	}

	@Override
	public void putChess(Position pos) {
		if (chessBoardIsEmpty) {
			chessBoardIsEmpty = false;
		}

		// 设置棋盘
		chessBoard[pos.x][pos.y] = OTHER_POINT;

		// 从可选的点中移除此点
		Iterator<Position> iterator = myOptionPoints.iterator();
		while (iterator.hasNext()) {
			Position currenPoint = iterator.next();
			if (currenPoint.x == pos.x && currenPoint.y == pos.y) {
				iterator.remove();
			}
		}
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
}
