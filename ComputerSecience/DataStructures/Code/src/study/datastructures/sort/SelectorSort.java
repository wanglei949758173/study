/*      
 * 模块编号  
 * 功能描述 
 * 文件名 SelectorSort.java 
 * 作者 王磊 
 * 编写日期 2020年04月23日 
 */
package study.datastructures.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class SelectorSort {
	public static void main(String[] args) {
		int[] array = { 4, 9, -3, 10, 12, 33 };
		System.out.println("排序前");
		System.out.println(Arrays.toString(array));
		System.out.println();

		System.out.println("排序后");
		sort(array);
		System.out.println(Arrays.toString(array));

	}

	/**
	 * 使用选择排序对数组进行排序
	 * @param array	数组
	 */
	public static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			// 找到最小值
			int minNum = array[i];
			int minNumIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				// 当前数<最小数，重置最小数和最小数索引
				if (array[j] < minNum) {
					minNum = array[j];
					minNumIndex = j;
				}
			}

			// 将最小值放到和第i个位置的值交换位置
			if (i != minNumIndex) {
				array[minNumIndex] = array[i];
				array[i] = minNum;
			}
		}

	}
}
