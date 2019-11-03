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
	 * 将二维数组转换为稀疏数组
	 * 
	 * @param array
	 *            二维数组
	 * @return 转换后的稀疏数组
	 */
	public int[][] array2SparseArray(int[][] array) {
		// 拿到二维数组中有效元素的个数
		int sum = findAvailableItemCount(array);

		// 创建稀疏数组
		int[][] sparseArray = new int[sum + 1][3];
		// 第一行写二维数组的行、列、和有效元素的个数
		sparseArray[0][0] = array.length;
		sparseArray[0][1] = array[0].length;
		sparseArray[0][2] = sum;

		// 将有效的元素信息写入到稀疏数组中
		return writeAvailableItem2SparseArray(array,sparseArray, sum);
	}

	/**
	 * 查找二维数组中有效元素的个数
	 * 
	 * @param array
	 *            二维数组
	 * @return 二维数组中有效元素的个数
	 */
	private int findAvailableItemCount(int[][] array) {
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
		return sum;
	}

	/**
	 * 将二维数据中有效的元素写入到稀疏数组中
	 * @param source			原始二维数组
	 * @param sparseArray		稀疏数组
	 * @param availableCount	有效元素个数
	 */
	private int[][] writeAvailableItem2SparseArray(int[][] source,
			int[][] sparseArray,
			int availableCount) {
		int count = 0; // 当前稀疏数组中存放的有效元素的个数
		for (int i = 0; i < source.length; i++) {
			// 拿到一行的所有元素
			int[] rowData = source[i];
			for (int j = 0; j < rowData.length; j++) {
				int data = source[i][j];
				if (data != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = data;
					
					// 有效元素已经取完，直接返回
					if (count == availableCount) {
						return sparseArray;
					}
				}
			}
		}
		
		throw new RuntimeException("数组：" + source + "中有效元素的个数小于" + availableCount + "个");
	}

	/**
	 * 将稀疏数组还原为二维数组
	 * 
	 * @param sparseArray	稀疏数组
	 * @return 				二维数组
	 */
	public int[][] sparseArray2Array(int[][] sparseArray) {
		// 创建二维数组
		int rowCount = sparseArray[0][0];
		int columnCount = sparseArray[0][1];
		int[][] array = new int[rowCount][columnCount];

		// 读取稀疏数组中的有效值，填充到二维数组中
		for (int i = 1; i < sparseArray.length; i++) {
			int rowIndex = sparseArray[i][0];
			int columnIndex = sparseArray[i][1];
			int itemValue = sparseArray[i][2];
			array[rowIndex][columnIndex] = itemValue;
		}

		return array;
	}

	/**
	 * 打印二维数组
	 * 
	 * @param array
	 *            二维数组
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
