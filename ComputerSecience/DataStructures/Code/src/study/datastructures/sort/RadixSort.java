/*      
 * 模块编号  
 * 功能描述 
 * 文件名 RadixSort.java 
 * 作者 王磊 
 * 编写日期 2020年05月17日 
 */
package study.datastructures.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		// 生成随机数
		int[] array = getRandomIntArray(80000000);
		LocalDateTime beginTime = LocalDateTime.now();
		printTime(beginTime);
		radixSort(array);
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
	 * 使用基数排序对数组进行排序
	 * @param array		数组
	 */
	public static void radixSort(int[] array) {
		// 找出数组中最大的元素的长度
		int maxNumber = findMaxNumber(array);
		int maxNumberLength = String.valueOf(maxNumber).length();

		// 初始化桶
		int[][] bucket = new int[10][array.length];
		// 每个桶中元素的个数
		int[] bucketLength = new int[10];

		int n = 1;
		for (int round = 1; round <= maxNumberLength; round++) {
			// 将元素按照个位数的大小放入相应的桶
			for (int i = 0; i < array.length; i++) {
				// 求出第n位的数,n从后完往前数
				int digit = array[i] / n % 10;

				// 放入相应的桶
				bucket[digit][bucketLength[digit]] = array[i];

				// 相应的桶的元素+1
				bucketLength[digit] = bucketLength[digit] + 1;
			}

			n *= 10;

			// 将桶中的元素按照顺序拷贝到原始数组
			int arrayIndex = 0;
			for (int i = 0; i < bucketLength.length; i++) {
				// 当前桶中存在元素
				if (bucketLength[i] > 0) {
					int currentBucketLength = bucketLength[i];
					int currentBucketIndex = 0;
					while (currentBucketIndex < currentBucketLength) {
						array[arrayIndex] = bucket[i][currentBucketIndex];
						arrayIndex += 1;
						currentBucketIndex += 1;
					}
				}

				// 重置桶中元素的个数
				bucketLength[i] = 0;
			}
		}

	}

	/**
	 * 查找数组中最大的数
	 * @param array	数组
	 * @return		数组中最大的数
	 */
	private static int findMaxNumber(int[] array) {
		return Arrays.stream(array).max().getAsInt();
	}
}
