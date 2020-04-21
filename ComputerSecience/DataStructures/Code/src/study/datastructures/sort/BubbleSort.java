/*      
 * 模块编号  
 * 功能描述 
 * 文件名 BubbleSort.java 
 * 作者 王磊 
 * 编写日期 2020年04月21日 
 */
package study.datastructures.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class BubbleSort {
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
	 * 冒泡排序
	 * @param array 数组
	 */
	public static void sort(int[] array) {
		// 进行n-1次冒泡的过程
		for (int i = 0; i < array.length - 1; i++) {
			// 冒泡
			boolean isExchange = false;
			for (int j = 0; j < array.length - 1; j++) {
				int current = array[j];
				int next = array[j + 1];
				// 交换位置
				if (current > next) {
					array[j + 1] = current;
					array[j] = next;
					isExchange = true;
				}
			}
			
			// 未交换位置,证明已经排好序
			if (!isExchange) {
				break;
			}
		}
	}
}
