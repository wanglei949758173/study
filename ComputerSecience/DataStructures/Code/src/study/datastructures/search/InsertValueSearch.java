/*      
 * 模块编号  
 * 功能描述 
 * 文件名 InsertValueSearch.java 
 * 作者 王磊 
 * 编写日期 2020年05月26日 
 */
package study.datastructures.search;

public class InsertValueSearch {
	public static void main(String[] args) {
		int[] arrary = new int[100];
		for (int i = 0; i < 100; i++) {
			arrary[i] = i;
		}

		int findIndex = insertValueSearch(arrary, 10, 0, 99);
		System.out.println(findIndex);
	}

	/**
	 * 差值查找
	 * @param arrary		数组
	 * @param findValue		查找的值
	 * @param left			查找数组的左索引
	 * @param right			查找数组的右索引
	 * @return				查找的值的索引
	 */
	public static int insertValueSearch(int[] arrary, int findValue, int left, int right) {
		System.out.println("insertValueSearch");
		if (left > right) {
			// 未找到
			return -1;
		}
		if (findValue > arrary[right]) {
			// 未找到
			return -1;
		}
		if (findValue < arrary[left]) {
			// 未找到
			return -1;
		}

		// 找到中间值
		int middleIndex =
				left + (findValue - arrary[left]) * (right - left) / (arrary[right] - arrary[left]);
		int middleValue = arrary[middleIndex];

		// 大于中间值,向右递归
		if (findValue > middleValue) {
			return insertValueSearch(arrary, findValue, middleIndex + 1, right);
		} else if (findValue < middleIndex) {
			// 小于中间值,向左递归
			return insertValueSearch(arrary, findValue, left, middleIndex - 1);
		} else {
			// 等于中间值,返回索引
			return middleIndex;
		}
	}
}
