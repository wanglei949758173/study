/*      
 * 模块编号  
 * 功能描述 
 * 文件名 QuickSort.java 
 * 作者 王磊 
 * 编写日期 2020年05月08日 
 */
package study.datastructures.sort;

import java.time.LocalDateTime;

public class QuickSort {
	public static void main(String[] args) {
		// 生成随机数
		int[] array = getRandomIntArray(80000000);
		LocalDateTime beginTime = LocalDateTime.now();
		printTime(beginTime);
		quickSort(array, 0, array.length - 1);
		LocalDateTime endTime = LocalDateTime.now();
		printTime(endTime);
	}

	private static void printTime(LocalDateTime time) {
		System.out.println(String.format("%d-%d-%d %d:%d:%d", time.getYear(), time.getMonthValue(),
				time.getDayOfMonth(), time.getHour(), time.getMinute(), time.getSecond()));
	}

	private static int[] getRandomIntArray(int length) {
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
		return array;
	}

	/**
	 * 使用快速排序算法对数组排序
	 * @param array		排序
	 * @param left		排序数组的左下标
	 * @param right		排序数组的右下标
	 */
	public static void quickSort(int[] array, int left, int right) {
		// 无序数组长度为1，排序完成
		if (left >= right) {
			return;
		}

		// 选取左边数字为基准值
		int pivot = array[left];
		// 左索引,右索引
		int l = left;
		int r = right;

		while (l < r) {
			// 交替遍历右边和左边,大于pivot的数放右边,小于pivot的数放左边
			while (array[r] >= pivot && r > l) {
				r--;
			}
			// 将小于pivot的数移到左边
			if (r > l) {
				array[l] = array[r];
			}
			while (array[l] < pivot && r > l) {
				l++;
			}
			// 将大于pivot的数移到右边
			if (r > l) {
				array[r] = array[l];
			}
			// 相等,将pivot放到此位置
			if (r == l) {
				array[r] = pivot;
			}
		}

		// 递归左边
		quickSort(array, left, l - 1);
		// 递归右边
		quickSort(array, l + 1, right);
	}

}
