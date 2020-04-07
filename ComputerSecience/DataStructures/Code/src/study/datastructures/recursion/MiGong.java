/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MiGong.java 
 * 作者 王磊 
 * 编写日期 2020年04月03日 
 */
package study.datastructures.recursion;

public class MiGong {
	/**
	 * 地图
	 */
	private static int[][] map = new int[8][7];

	/**
	 * 空，代表未走过
	 */
	private static final int EMPTY = 0;

	/**
	 * 墙
	 */
	private static final int WALL = 1;

	/**
	 * 通路
	 */
	private static final int WAY = 2;

	/**
	 * 走不通
	 */
	private static final int NO_WAY = 3;

	public static void main(String[] args) {
		// 初始化迷宫
		initMiGong();
		printMiGong();

		// 找通路
		new MiGong().findWay(map, 1, 1, 6, 5);
		System.out.println();
		printMiGong();
	}

	// 初始化迷宫
	private static void initMiGong() {
		// 第一行
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = WALL;
		}

		// 最后一行
		for (int i = 0; i < map[0].length; i++) {
			map[map.length - 1][i] = WALL;
		}

		// 第一列
		for (int i = 0; i < map.length; i++) {
			map[i][0] = WALL;
		}

		// 最后一列
		for (int i = 0; i < map.length; i++) {
			map[i][map[0].length - 1] = WALL;
		}

		// 4-2
		map[3][1] = WALL;

		// 4-3
		map[3][2] = WALL;
	}

	private static void printMiGong() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.printf(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * 寻找通路
	 * @param map		地图
	 * @param startX	起点X
	 * @param startY	起点Y
	 * @param endX		终点X
	 * @param endY		终点Y
	 */
	public boolean findWay(int[][] map, int startX, int startY, int endX, int endY) {
		// 终点已经到达
		if (map[endX][endY] == WAY) {
			return true;
		} else {
			// 按照 下->右->上->左的顺序走
			if (map[startX][startY] == EMPTY) {
				// 假定当前点可以走通
				map[startX][startY] = WAY;

				// 下,右，上，左
				int downX = startX + 1;
				int downY = startY;

				int rightX = startX;
				int rightY = startY + 1;

				int upX = startX - 1;
				int upY = startY;

				int leftX = startX;
				int leftY = startY - 1;
				
				if (findWay(map, downX, downY, endX, endY)) {
					return true;
				} else if (findWay(map, rightX, rightY, endX, endY)) {
					return true;
				} else if (findWay(map, upX, upY, endX, endY)) {
					return true;
				} else if (findWay(map, leftX, leftY, endX, endY)) {
					return true;
				} else {
					// 此路不通
					map[startX][startY] = NO_WAY;
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
