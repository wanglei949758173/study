/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ShellSort.java 
 * 作者 王磊 
 * 编写日期 2020年04月29日 
 */
package study.datastructures.sort;

import java.time.LocalDateTime;

/**
 * 希尔排序
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class ShellSort {
	public static void main(String[] args) {
		// 生成随机数
		int[] array = getRandomIntArray(8000000);
		LocalDateTime beginTime = LocalDateTime.now();
		printTime(beginTime);
		sortByExchange(array);
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
	 * 希尔排序(交换方式)
	 * @param array		数组
	 */
	public static void sortByExchange(int[] array) {
		// d为增量,当增量=1时，结束
		for (int d = array.length / 2; d >= 1; d /= 2) {
			// 对[d,d+1,....n]进行直接插入排序
			// d之前的数是有序的(只有1个数)
			for (int i = d; i < array.length; i++) {
				// i代表当前要插入的数的index,(i-d)代表要插入的数的上一个数
				for (int j = i - d; j >= 0; j -= d) {
					// 如果前者大于后者，则交换位置
					if (array[j] > array[j + d]) {
						int temp = array[j];
						array[j] = array[j + d];
						array[j + d] = temp;
					}
				}
			}
		}
	}

	/**
	 * 希尔排序(移动方式)
	 * @param array		数组
	 */
	public static void sortByMove(int[] array) {
		// d为增量,当增量=1时，结束
		for (int d = array.length / 2; d >= 1; d /= 2) {
			// 对[d,d+1,....n]进行直接插入排序
			// d之前的数是有序的(只有1个数)
			for (int i = d; i < array.length; i++) {
				// i代表当前要插入的数的index,(i-d)代表要插入的数的上一个数
				int insertedNumber = array[i];
				int j = i - d;
				for (; j >= 0; j -= d) {
					// 如果当前数大于要插入的数，则后移当前数
					if (array[j] > insertedNumber) {
						array[j + d] = array[j];
					} else {
						break;
					}
				}
				// 待插入的位置
				array[j + d] = insertedNumber;
			}
		}
	}
}
