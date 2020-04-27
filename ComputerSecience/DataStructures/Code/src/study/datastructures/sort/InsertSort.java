/*      
 * 模块编号  
 * 功能描述 
 * 文件名 InsertSort.java 
 * 作者 王磊 
 * 编写日期 2020年04月25日 
 */
package study.datastructures.sort;

import java.time.LocalDateTime;

public class InsertSort {

	public static void main(String[] args) {
		// int[] array = { 3, 6, 9, 1, 3, 5, 6 };
		// System.out.println("排序前");
		// System.out.println(Arrays.toString(array));
		//
		// insertSort(array);
		//
		// System.out.println("排序后");
		// System.out.println(Arrays.toString(array));

		// 生成随机数
		int[] array = getRandomIntArray(800000);
		LocalDateTime beginTime = LocalDateTime.now();
		printTime(beginTime);
		insertSort(array);
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

	public static void insertSort(int[] array) {
		// 共进行n-1轮,从第2个元素开始
		for (int i = 1; i < array.length; i++) {
			// 插入的位置
			int insertIndex = i;
			// 插入的值
			int insertValue = array[insertIndex];
			// 保证数组不越界&&插入的值<前一个的值
			while (insertIndex > 0 && insertValue < array[insertIndex - 1]) {
				// 将前一个数字后移
				array[insertIndex] = array[insertIndex - 1];
				// 插入位置向前移动
				insertIndex--;
			}

			// 找到插入的位置,放置insertValue到此位置
			if (array[insertIndex] != insertValue) {
				array[insertIndex] = insertValue;
			}
		}
	}
}
