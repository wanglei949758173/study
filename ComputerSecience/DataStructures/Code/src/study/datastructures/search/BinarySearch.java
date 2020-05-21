/*      
 * 模块编号  
 * 功能描述 
 * 文件名 BinarySearch.java 
 * 作者 王磊 
 * 编写日期 2020年05月21日 
 */
package study.datastructures.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = { 1, 8, 10, 89, 89, 89, 1000, 1234 };
		int searchValue = 89;
		List<Integer> result = binarySearch(array, searchValue, 0, array.length - 1);
		System.out.println(result.toString());
	}

	/**
	 * 二分查找
	 * @param array			排好序的数组
	 * @param searchValue	查询的值
	 * @param left			左索引
	 * @param right			右索引
	 * @return				查询到的下标
	 */
	public static List<Integer> binarySearch(int[] array, int searchValue, int left, int right) {
		// 未找到查询的值
		if (left > right) {
			return new ArrayList<>();
		}
		// 获取中间值
		int midIndex = (left + right) / 2;
		int midValue = array[midIndex];

		// 大于中间值,向右递归
		if (searchValue > midValue) {
			return binarySearch(array, searchValue, midIndex + 1, right);
		} else if (searchValue < midValue) {
			// 小于中间值,向左递归
			return binarySearch(array, searchValue, left, midIndex - 1);
		} else {
			List<Integer> result = new ArrayList<>();
			// 等于中间值
			result.add(midIndex);
			// 向左查找相等的值
			int tempIndex = midIndex - 1;
			while (tempIndex >= 0 && array[tempIndex] == searchValue) {
				result.add(tempIndex);
				tempIndex -= 1;
			}

			// 向右查找相等得值
			tempIndex = midIndex + 1;
			while (tempIndex <= array.length - 1 && array[tempIndex] == searchValue) {
				result.add(tempIndex);
				tempIndex += 1;
			}
			return result;
		}
	}
}
