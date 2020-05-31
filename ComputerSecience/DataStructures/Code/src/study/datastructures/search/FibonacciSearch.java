/*      
 * 模块编号  
 * 功能描述 
 * 文件名 FibonacciSearch.java 
 * 作者 王磊 
 * 编写日期 2020年05月31日 
 */
package study.datastructures.search;

import java.util.Arrays;

public class FibonacciSearch {
	public static void main(String[] args) {
		int[] array = { 1, 8, 10, 89, 1000, 1234 };
		int valueIndex = fibSearch(array, 1);
		System.out.println(valueIndex);
	}

	/**
	 * 斐波那契查找算法
	 * @param array			数组
	 * @param findValue		查找的值
	 * @return				查找的值的索引
	 */
	public static int fibSearch(int[] array, int findValue) {
		int low = 0;
		int high = array.length - 1;
		int n = 0;
		// 获得一个斐波那契数列(fib[n] >= array.length)
		int[] fibArray = getFibArray(20);
		while (fibArray[n] < array.length) {
			n++;
		}

		// 如果fib[n] > array.length,扩充数组
		int[] tempArray = Arrays.copyOf(array, fibArray[n]);
		if (fibArray[n] > array.length) {
			for (int i = array.length; i < tempArray.length; i++) {
				tempArray[i] = array[array.length - 1];
			}
		}

		while (low <= high) {
			// 获取mid值
			int middleIndex = low + fibArray[n - 1] - 1;
			int middleValue = tempArray[middleIndex];

			// 查找的值<mid值,斐波那契数列n--
			if (findValue < middleValue) {
				n -= 1;
				high = middleIndex - 1;
			} else if (findValue > middleValue) {
				// 查找的值>mid值,斐波那契数列n -= 2
				low = middleIndex + 1;
				n -= 2;
			} else {
				// 查找到当前值
				if (middleIndex <= array.length - 1) {
					return middleIndex;
				} else {
					return array.length - 1;
				}
			}

		}
		// 未找到
		return -1;
	}

	/**
	 * 获取斐波那契数列
	 * @param length	斐波那契数列长度
	 * @return			斐波那契数列
	 */
	public static int[] getFibArray(int length) {
		int[] fibArray = new int[length];
		fibArray[0] = 1;
		if (length == 1) {
			return fibArray;
		}

		fibArray[1] = 1;
		if (length == 2) {
			return fibArray;
		}

		for (int i = 2; i < fibArray.length; i++) {
			fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
		}
		return fibArray;
	}
}
