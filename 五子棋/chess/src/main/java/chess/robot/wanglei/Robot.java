package chess.robot.wanglei;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.rockzhai.ai.Node;

import chess.robot.IRobot;
import chess.robot.Position;

public class Robot implements IRobot {
	// 无子
	private static final int NO_POINT = 0;

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

	private static int dr[] = new int[] { -1, 1, -1, 1, 0, 0, -1, 1 }; // 方向向量
	private static int dc[] = new int[] { 1, -1, -1, 1, -1, 1, 0, 0 }; // 方向向量

	public static final int MAXN = 1 << 28;
	public static final int MINN = -MAXN;
	private static int searchDeep = 4; // 搜索深度

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
			return result;
		}

		// 棋盘不为空
		// 裁剪算法，选中最优点
		Node node = new Node();
		dfs(0, node, MINN, MAXN, null);
		result = node.bestChild.p;

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

	/*
	 * 首先遍历整个棋盘，如果该点非空，进入该点权重计算 该点向左遍历，出现连续同色的棋子，进行加1，cnt++
	 * 向右遍历，出现连续同色的棋子，进行加1，cnt++ 若两边无封堵、则权重= cnt*cnt颜色的值（白：1，黑-1）
	 * 若一边出现封堵，则权重=cnt*cnt颜色的值/4 若两边封堵，则权重=0； 若 cnt 大于等与5，权重为最大值*颜色的值（白：1，黑-1）
	 * 总权重是每个点四个方向（行、列、左右对角线）的权重之和
	 */
	private static int getMark() {
		int res = 0;
		for (int i = 1; i <= CHESS_BOARD_SIZE; ++i) {
			for (int j = 1; j <= CHESS_BOARD_SIZE; ++j) {
				// 对所有落子的点进行计算
				if (chessBoard[i][j] != NO_POINT) {
					// 行
					boolean flag1 = false, flag2 = false;

					// 当前棋子的坐标
					int currentX = j, currentY = i;

					// 连续相同颜色个数的棋子
					int cnt = 1;

					// 棋盘左边有连续相同颜色的棋子个数
					int col = currentX, row = currentY;
					while (--col > 0
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;

					// 左边无封堵
					if (col > 0 && chessBoard[row][col] == NO_POINT)
						flag1 = true;

					// 棋盘右边有连续相同颜色的棋子个数
					col = currentX;
					row = currentY;
					while (++col <= CHESS_BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;

					// 右边无封堵
					if (col <= CHESS_BOARD_SIZE && chessBoard[row][col] == NO_POINT)
						flag2 = true;

					// 两侧均无封堵
					if (flag1 && flag2) {
						res += chessBoard[i][j] * cnt * cnt;
					} else if (flag1 || flag2) {
						// 一边有封堵
						res += chessBoard[i][j] * cnt * cnt / 4;
					}

					// 若 cnt 大于等与5，权重为最大值*颜色的值（白：1，黑-1）
					if (cnt >= 5) {
						res = MAXN * chessBoard[i][j];
					}

					// 列
					col = currentX;
					row = currentY;
					cnt = 1;
					flag1 = false;
					flag2 = false;
					while (--row > 0
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;
					if (row > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = currentX;
					row = currentY;
					while (++row <= CHESS_BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;
					if (row <= CHESS_BOARD_SIZE && chessBoard[row][col] == 0)
						flag2 = true;
					if (flag1 && flag2)
						res += chessBoard[i][j] * cnt * cnt;
					else if (flag1 || flag2)
						res += chessBoard[i][j] * cnt * cnt / 4;
					if (cnt >= 5)
						res = MAXN * chessBoard[i][j];

					// 左对角线
					col = currentX;
					row = currentY;
					cnt = 1;
					flag1 = false;
					flag2 = false;
					while (--col > 0 && --row > 0
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;
					if (col > 0 && row > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = currentX;
					row = currentY;
					while (++col <= CHESS_BOARD_SIZE && ++row <= CHESS_BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;
					if (col <= CHESS_BOARD_SIZE && row <= CHESS_BOARD_SIZE
							&& chessBoard[row][col] == 0)
						flag2 = true;
					if (flag1 && flag2)
						res += chessBoard[i][j] * cnt * cnt;
					else if (flag1 || flag2)
						res += chessBoard[i][j] * cnt * cnt / 4;
					if (cnt >= 5)
						res = MAXN * chessBoard[i][j];

					// 右对角线
					col = currentX;
					row = currentY;
					cnt = 1;
					flag1 = false;
					flag2 = false;
					while (++row <= CHESS_BOARD_SIZE && --col > 0
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;
					if (row <= CHESS_BOARD_SIZE && col > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = currentX;
					row = currentY;
					while (--row > 0 && ++col <= CHESS_BOARD_SIZE
							&& chessBoard[row][col] == chessBoard[currentY][currentX])
						++cnt;
					if (row > 0 && col <= CHESS_BOARD_SIZE && chessBoard[i][j] == 0)
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

	// alpha beta dfs
	private static void dfs(int deep, Node root, int alpha, int beta, Position p) {
		if (deep == searchDeep) {
			root.mark = getMark();
			return;
		}

		// 临时保存可选的所有点
		ArrayList<Position> myOptionPointsTemp = new ArrayList<Position>();
		Iterator<Position> it = myOptionPoints.iterator();
		while (it.hasNext()) {
			Position now = it.next();
			myOptionPointsTemp.add(now);
		}

		// 构建决策树
		it = myOptionPointsTemp.iterator();
		while (it.hasNext()) {
			Position now = it.next();
			Node node = new Node();
			node.setPoint(now);
			root.addChild(node);

			// 判断可选的点里是否包含了当前点
			boolean flag = containsPosition(myOptionPointsTemp, now);
			chessBoard[now.y][now.x] = ((deep & 1) == 1) ? -1 : 1;
			// if (isEnd(now.x, now.y)) {
			// root.bestChild = node;
			// root.mark = MAXN * chessBoard[now.y][now.x];
			// chessBoard[now.y][now.x] = 0;
			// return;
			// }

			// 标记回溯时要不要删掉
			boolean flags[] = new boolean[8]; 
			Arrays.fill(flags, true);
			for (int i = 0; i < 8; ++i) {
				Position removedPosition = new Position();
				Position next = removedPosition;
				next.setX(now.x + dc[i]);
				next.setY(now.y + dr[i]);
				if (1 <= now.x + dc[i] && now.x + dc[i] <= CHESS_BOARD_SIZE
						&& 1 <= now.y + dr[i]
						&& now.y + dr[i] <= CHESS_BOARD_SIZE
						&& chessBoard[next.y][next.x] == 0) {
					if (!toJudge.contains(next)) 
						toJudge.add(next);
					} else
						flags[i] = false;
				}
			}

			if (flag)
				toJudge.remove(now);
			dfs(deep + 1, root.getLastChild(), alpha, beta, now);
			chessBoard[now.y][now.x] = 0;
			if (flag)
				toJudge.add(now);

			for (int i = 0; i < 8; ++i)
				if (flags[i]) {
					Position removedPosition = new Position();
					removedPosition.setX(now.x + dc[i]);
					removedPosition.setY(now.y + dr[i]);
					toJudge.remove(removedPosition);
				}
			// alpha beta剪枝
			// min层
			if ((deep & 1) == 1) {
				if (root.bestChild == null
						|| root.getLastChild().mark < root.bestChild.mark) {
					root.bestChild = root.getLastChild();
					root.mark = root.bestChild.mark;
					if (root.mark <= MINN)
						root.mark += deep;
					beta = Math.min(root.mark, beta);
				}
				if (root.mark <= alpha)
					return;
			}
			// max层
			else {
				if (root.bestChild == null
						|| root.getLastChild().mark > root.bestChild.mark) {
					root.bestChild = root.getLastChild();
					root.mark = root.bestChild.mark;
					if (root.mark == MAXN)
						root.mark -= deep;
					alpha = Math.max(root.mark, alpha);
				}
				if (root.mark >= beta)
					return;
			}
		}
		// if(deep==0)
		// System.out.printf("******************************************\n");
	}

	// 判断是否一方取胜
	// public static boolean isEnd(int x, int y) {
	// // 判断一行是否五子连珠
	// int cnt = 1;
	// int col = x, row = y;
	// while (--col > 0 && chessBoard[row][col] == chessBoard[y][x])
	// ++cnt;
	// col = x;
	// row = y;
	// while (++col <= size && chessBoard[row][col] == chessBoard[y][x])
	// ++cnt;
	// if (cnt >= 5) {
	// isFinished = true;
	// return true;
	// }
	// // 判断一列是否五子连珠
	// col = x;
	// row = y;
	// cnt = 1;
	// while (--row > 0 && chessBoard[row][col] == chessBoard[y][x])
	// ++cnt;
	// col = x;
	// row = y;
	// while (++row <= size && chessBoard[row][col] == chessBoard[y][x])
	// ++cnt;
	// if (cnt >= 5) {
	// isFinished = true;
	// return true;
	// }
	// // 判断左对角线是否五子连珠
	// col = x;
	// row = y;
	// cnt = 1;
	// while (--col > 0 && --row > 0 && chessBoard[row][col] == chessBoard[y][x])
	// ++cnt;
	// col = x;
	// row = y;
	// while (++col <= size && ++row <= size && chessBoard[row][col] ==
	// chessBoard[y][x])
	// ++cnt;
	// if (cnt >= 5) {
	// isFinished = true;
	// return true;
	// }
	// // 判断右对角线是否五子连珠
	// col = x;
	// row = y;
	// cnt = 1;
	// while (++row <= size && --col > 0 && chessBoard[row][col] ==
	// chessBoard[y][x])
	// ++cnt;
	// col = x;
	// row = y;
	// while (--row > 0 && ++col <= size && chessBoard[row][col] ==
	// chessBoard[y][x])
	// ++cnt;
	// if (cnt >= 5) {
	// isFinished = true;
	// return true;
	// }
	// return false;
	// }

	private static boolean containsPosition(Collection<Position> positions,
			Position position) {
		Iterator<Position> iterator = positions.iterator();
		while (iterator.hasNext()) {
			Position currentPosition = iterator.next();
			if (currentPosition.x == position.x && currentPosition.y == position.y) {
				return true;
			}
		}

		return false;
	}
}
