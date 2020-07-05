/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HeapSort.java 
 * 作者 王磊 
 * 编写日期 2020年07月02日 
 */
package study.datastructures.tree;

import java.time.LocalDateTime;

/**
 * 堆排序
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class HeapSort {
	public static void main(String[] args) {
		// 生成随机数
		int[] array = getRandomIntArray(8000000);
		LocalDateTime beginTime = LocalDateTime.now();
		printTime(beginTime);
		heapSort(array);
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
	 * 对数组array进行堆排序
	 * @param array
	 */
	public static void heapSort(int[] array) {
		// 构建大顶堆
		buildHeap(array, array.length);

		for (int i = array.length - 1; i >= 0; i--) {
			// 交换第1个位置和最后一个位置
			swap(array, 0, i);
			// 对0~i-1个位置重新heapfiy
			heapfiy(array, 0, i - 1);
		}
	}

	/**
	 * 将数组tree构建成一个大顶堆
	 * @param tree		数组形式的树
	 * @param length	树的长度
	 */
	public static void buildHeap(int[] tree, int length) {
		// 从最后一个节点的父节点,按照从右到左从上到下依次进行heapfiy
		int lastNodeIndex = length - 1;
		int parentIndex = (lastNodeIndex - 1) / 2;
		for (int i = parentIndex; i >= 0; i--) {
			heapfiy(tree, i, lastNodeIndex);
		}
	}

	/**
	 * 将一个树 tree的 beginIndex~endIndex 的子树构造成一个大顶堆
	 * @param tree				树
	 * @param beginIndex		调整的起始节点索引(此节点后的所有子树均是大顶堆)
	 * @param endIndex			调整的结束节点的索引
	 */
	public static void heapfiy(int[] tree, int beginIndex, int endIndex) {
		// 从左节点开始调整
		int leftIndex = beginIndex * 2 + 1;
		int rightIndex = leftIndex + 1;
		for (int i = leftIndex; i <= endIndex; i = i * 2 + 1) {
			int leftValue = tree[leftIndex];
			// 左节点小于右节点
			if (rightIndex <= endIndex && leftValue < tree[rightIndex]) {
				i = rightIndex;// i指向右节点
			}

			// 子节点大于跟节点,交换位置
			if (tree[i] > tree[beginIndex]) {
				swap(tree, i, beginIndex);
				// 继续调整变化的子树
				beginIndex = i;
				leftIndex = beginIndex * 2 + 1;
				rightIndex = leftIndex + 1;
			} else {
				// 当前堆为大顶堆,又因为子树为大顶堆,因此直接返回
				return;
			}
		}
	}

	// 交换位置
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
