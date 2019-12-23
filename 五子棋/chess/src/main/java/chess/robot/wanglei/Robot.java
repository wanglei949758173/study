package chess.robot.wanglei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import chess.robot.IRobot;
import chess.robot.Position;

public class Robot implements IRobot {
	public static boolean isBlack = false;// 标志棋子的颜色
	public static int[][] chessBoard = new int[17][17]; // 棋盘棋子的摆放情况：0无子，1黑子，－1白子
	private static HashSet<Position> toJudge = new HashSet<Position>(); // ai可能会下棋的点
	private static int dr[] = new int[] { -1, 1, -1, 1, 0, 0, -1, 1 }; // 方向向量
	private static int dc[] = new int[] { 1, -1, -1, 1, -1, 1, 0, 0 }; // 方向向量
	public static final int MAXN = 1 << 28;
	public static final int MINN = -MAXN;
	private static int searchDeep = 5; // 搜索深度
	private static final int size = 15; // 棋盘大小
	public static boolean isFinished = false;

	@Override
	public String playerName() {
		return "王磊";
	}

	@Override
	public void play(boolean black) {
		Node node=new Node();  
        dfs(0,node,MINN,MAXN,null);  
        Position now=node.bestChild.p;  
        
        isBlack=black;  
	}

	@Override
	public Position nextStep() {
		return null;
	}

	@Override
	public void putChess(Position pos) {

	}

	public static int getMark() {
		int res = 0;
		for (int i = 1; i <= size; ++i) {
			for (int j = 1; j <= size; ++j) {
				if (chessBoard[i][j] != 0) {
					// 行
					boolean flag1 = false, flag2 = false;
					int x = j, y = i;
					int cnt = 1;
					int col = x, row = y;
					while (--col > 0 && chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (col > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = x;
					row = y;
					while (++col <= size && chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (col <= size && chessBoard[row][col] == 0)
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
					while (++row <= size && chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (row <= size && chessBoard[row][col] == 0)
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
					while (++col <= size && ++row <= size
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (col <= size && row <= size && chessBoard[row][col] == 0)
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
					while (++row <= size && --col > 0
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (row <= size && col > 0 && chessBoard[row][col] == 0)
						flag1 = true;
					col = x;
					row = y;
					while (--row > 0 && ++col <= size
							&& chessBoard[row][col] == chessBoard[y][x])
						++cnt;
					if (row > 0 && col <= size && chessBoard[i][j] == 0)
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
		ArrayList<Position> judgeSet = new ArrayList<Position>();
		Iterator<Position> it = toJudge.iterator();
		while (it.hasNext()) {
			Position now = it.next();
			judgeSet.add(now);
		}
		it = judgeSet.iterator();
		while (it.hasNext()) {
			Position now = it.next();
			Node node = new Node();
			node.setPoint(now);
			root.addChild(node);
			boolean flag = toJudge.contains(now);
			chessBoard[now.y][now.x] = ((deep & 1) == 1) ? -1 : 1;
			if (isEnd(now.x, now.y)) {
				root.bestChild = node;
				root.mark = MAXN * chessBoard[now.y][now.x];
				chessBoard[now.y][now.x] = 0;
				return;
			}

			boolean flags[] = new boolean[8]; // 标记回溯时要不要删掉
			Arrays.fill(flags, true);
			for (int i = 0; i < 8; ++i) {
				Position removedPosition = new Position();
				Position next = removedPosition;
				next.setX(now.x + dc[i]);
				next.setY(now.y + dr[i]);
				if (1 <= now.x + dc[i] && now.x + dc[i] <= size && 1 <= now.y + dr[i]
						&& now.y + dr[i] <= size && chessBoard[next.y][next.x] == 0) {
					if (!toJudge.contains(next)) {
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
    public static boolean isEnd(int x,int y){  
        // 判断一行是否五子连珠  
        int cnt=1;  
        int col=x,row=y;  
        while(--col>0 && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        col=x;row=y;  
        while(++col<=size && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        if(cnt>=5){  
            isFinished=true;  
            return true;  
        }  
        // 判断一列是否五子连珠  
        col=x;row=y;  
        cnt=1;  
        while(--row>0 && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        col=x;row=y;  
        while(++row<=size && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        if(cnt>=5){  
            isFinished=true;  
            return true;  
        }  
        // 判断左对角线是否五子连珠  
        col=x;row=y;  
        cnt=1;  
        while(--col>0 && --row>0 && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        col=x;row=y;  
        while(++col<=size && ++row<=size && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        if(cnt>=5){  
            isFinished=true;  
            return true;  
        }  
        // 判断右对角线是否五子连珠  
        col=x;row=y;  
        cnt=1;  
        while(++row<=size && --col>0 && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        col=x;row=y;  
        while(--row>0 && ++col<=size && chessBoard[row][col]==chessBoard[y][x]) ++cnt;  
        if(cnt>=5){  
            isFinished=true;  
            return true;  
        }  
        return false;  
    }  
}
