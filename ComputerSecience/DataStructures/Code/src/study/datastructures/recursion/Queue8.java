/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Queue8.java 
 * 作者 王磊 
 * 编写日期 2020年04月07日 
 */
package study.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 8皇后问题
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Queue8 {
	private static final int MAX = 8;

	private List<int[]> solutions = new ArrayList<>();

	public List<int[]> getSolutions() {
		return this.solutions;
	}

	/**
	 * 解决方案,值为当前行所在的列索引
	 */
	private int[] solution = new int[MAX];

	/**
	 * 放置皇后
	 * @param queueIndex	当前皇后的索引
	 */
	private void pushQueue(int queueIndex) {
		if (queueIndex == (MAX + 1)) {
			// 最后一个已经放好
			solutions.add(solution.clone());
			return;
		}

		// 依次放入皇后
		for (int i = 0; i < MAX; i++) {
			// 将当前皇后放入该行第一列
			int currentRowNo = queueIndex - 1;
			solution[currentRowNo] = i;

			if (!isConflict(queueIndex)) {
				// 不冲突,放置下一个皇后
				pushQueue(queueIndex + 1);
			} else {
				// 冲突，将当前皇后移至下一列
				continue;
			}
		}
	}

	/**
	 * 判断当前放置的皇后是否导致冲突
	 * @param queueIndex	当前皇后索引
	 * @return				true-有冲突
	 * 						false-无冲突
	 */
	private boolean isConflict(int queueIndex) {
		int currentRowNo = queueIndex - 1;
		for (int i = 0; i < currentRowNo; i++) {
			// 是否在同一列
			boolean columnNoEquals = solution[i] == solution[currentRowNo];
			// 是否在同一行
			boolean rowNoEquals = false;
			// 是否在同一斜线上
			boolean isDiagonal =
					Math.abs(currentRowNo - i) == Math.abs(solution[currentRowNo] - solution[i]);

			if (columnNoEquals || rowNoEquals || isDiagonal) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		queue8.pushQueue(1);

		queue8.getSolutions().forEach(solution -> {
			for (int i = 0; i < solution.length; i++) {
				System.out.printf(solution[i] + " ");
			}
			System.out.println();
		});
	}
}
