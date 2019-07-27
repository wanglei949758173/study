package study.datastructures.list;

/**
 * 稀疏数组测试
 * 
 * @author Administrator
 *
 */
public class SparseArray {
	public static void main(String[] args) {
		// 创建原始数组
		int[][] array = new int[13][12];
		array[1][2] = 1;
		array[2][3] = 2;
		
		SparseArray sparseArray = new SparseArray();
		// 打印原始数组
		System.out.println("原始数组");
		sparseArray.printArray(array);
		System.out.println();
		
		// 转换为稀疏数组
		int[][] sparseArrays = sparseArray.array2SparseArray(array);
		// 打印稀疏数组
		System.out.println("稀疏数组");
		sparseArray.printArray(sparseArrays);
		System.out.println();
		
		// 转换为原始数组
		int[][] arrays = sparseArray.sparseArray2Array(sparseArrays);
		System.out.println("原始数组");
		sparseArray.printArray(arrays);
		System.out.println();
	}

	/**
	 * 将原始数组转换为稀疏数组
	 * 
	 * @param array 原始数组
	 * @return 稀疏数组
	 */
	public int[][] array2SparseArray(int[][] array) {
		// 拿到原始数据中有效元素的个数
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			// 拿到一行的所有元素
			int[] rowData = array[i];
			for (int j = 0; j < rowData.length; j++) {
				int data = array[i][j];
				if (data != 0) {
					sum++;
				}
			}
		}

		// 创建稀疏数组
		int[][] sparseArray = new int[sum + 1][3];
		// 遍历原始数组,将值写入到稀疏数组中
		sparseArray[0][0] = array.length;
		sparseArray[0][1] = array[0].length;
		sparseArray[0][2] = sum;

		int count = 0; // 当前稀疏数组中存放的有效元素的个数
		for (int i = 0; i < array.length; i++) {
			// 拿到一行的所有元素
			int[] rowData = array[i];
			for (int j = 0; j < rowData.length; j++) {
				int data = array[i][j];
				if (data != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = data;

				}
			}
		}

		// 返回
		return sparseArray;
	}

	/**
	 * 将稀疏数组还原为原始数组
	 * 
	 * @param sparseArray 稀疏数组
	 * @return 原始数组
	 */
	public int[][] sparseArray2Array(int[][] sparseArray) {
		// 创建原始数组
		int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];

		// 读取剩余的行,将值赋值给原始数组
		for (int i = 1; i < sparseArray.length; i++) {
			int row = sparseArray[i][0];
			int column = sparseArray[i][1];
			int data = sparseArray[i][2];
			array[row][column] = data;
		}

		return array;
	}

	/**
	 * 打印二维数组
	 * 
	 * @param array 二维数组
	 */
	public void printArray(int[][] array) {
		for (int[] rowDatas : array) {
			for (int data : rowDatas) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}
}
