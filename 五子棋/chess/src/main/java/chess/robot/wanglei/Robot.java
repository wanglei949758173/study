package chess.robot.wanglei;

import java.awt.Point;
import java.util.HashSet;

import chess.robot.IRobot;
import chess.robot.Position;

public class Robot implements IRobot {
	// 棋盘大小
	private static final int BOARD_SIZE = 19;
	public static final int MAXN = 1 << 28;
	// 棋盘：0无子，1黑子，－1白子
	public static int[][] chessBoard = new int[BOARD_SIZE][BOARD_SIZE];
	// 自己会下的点
	private static HashSet<Point> toJudge = new HashSet<Point>();

	@Override
	public String playerName() {
		return "王磊";
	}

	@Override
	public void play(boolean isBlack) {

	}

	@Override
	public Position nextStep() {
		return null;
	}

	@Override
	public void putChess(Position pos) {

	}

	// 进行分数的估算
	public static int getMark() {
		int res = 0;
		// 遍历棋盘
		for (int i = 1; i <= BOARD_SIZE; ++i) {
			for (int j = 1; j <= BOARD_SIZE; ++j) {
				if (chessBoard[i][j] != 0) {
					// 行
					boolean flag1 = false;
					boolean flag2 = false;
					int x = j, y = i;
					int cnt = 1;
					int col = x, row = y;
					while (--col > 0 && chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (col > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = x;
					row = y;
					while (++col <= BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (col <= BOARD_SIZE && chessBoard[row][col] == 0)
						flag2 = true;
					if (flag1 && flag2)
						res += chessBoard[i][j] * cnt * cnt;
					else if (flag1 || flag2)
						res += chessBoard[i][j] * cnt * cnt / 4;
					if (cnt >= 5)
						res = MAXN * chessBoard[i][j];
					// 列
					col = x;
					row = y;
					cnt = 1;
					flag1 = false;
					flag2 = false;
					while (--row > 0 && chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (row > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = x;
					row = y;
					while (++row <= BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (row <= BOARD_SIZE && chessBoard[row][col] == 0)
						flag2 = true;
					if (flag1 && flag2)
						res += chessBoard[i][j] * cnt * cnt;
					else if (flag1 || flag2)
						res += chessBoard[i][j] * cnt * cnt / 4;
					if (cnt >= 5)
						res = MAXN * chessBoard[i][j];
					// 左对角线
					col = x;
					row = y;
					cnt = 1;
					flag1 = false;
					flag2 = false;
					while (--col > 0 && --row > 0
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (col > 0 && row > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = x;
					row = y;
					while (++col <= BOARD_SIZE && ++row <= BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (col <= BOARD_SIZE && row <= BOARD_SIZE
							&& chessBoard[row][col] == 0)
						flag2 = true;
					if (flag1 && flag2)
						res += chessBoard[i][j] * cnt * cnt;
					else if (flag1 || flag2)
						res += chessBoard[i][j] * cnt * cnt / 4;
					if (cnt >= 5)
						res = MAXN * chessBoard[i][j];
					// 右对角线
					col = x;
					row = y;
					cnt = 1;
					flag1 = false;
					flag2 = false;
					while (++row <= BOARD_SIZE && --col > 0
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (row <= BOARD_SIZE && col > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = x;
					row = y;
					while (--row > 0 && ++col <= BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (row > 0 && col <= BOARD_SIZE && chessBoard[i][j] == 0)
						flag2 = true;
					if (flag1 && flag2)
						res += chessBoard[i][j] * cnt * cnt;
					else if (flag1 || flag2)
						res += chessBoard[i][j] * cnt * cnt / 4;
					if (cnt >= 5)
						res = MAXN * chessBoard[i][j];

				}
			}
		}
		return res;
	}

}
