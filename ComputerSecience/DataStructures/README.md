# 1. 线性结构
## 1.1 稀疏数组
### 定义
  * 能够将**多维数组**的**有效数据进行压缩**的一种**数据结构**。<br />
  * 稀疏数组的压缩处理方法如下:
    1. 记录数组一共有几行几列，有多少个不同的值
    2. 把具有不同值的元素的**行**、**列**及**值**记录在一个小规模的数组中，从而缩小程序的规模

### 应用场景
  * 当一个数组中**大部分元素为0，或者为同一个值的数组**时，可以使用稀疏数组来保存该数组。

### 应用实例
* 使用稀疏数组来保存如下的棋盘
  ![sparsearray-1](/assets/sparsearray-1.jpg)
* 思路分析
  ![sparsearray-2](/assets/sparsearray-2.jpg)
* 代码实现
  * 二维数组转稀疏数组
    ```java
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
    ```
  * 稀疏数组转换为二维数组
    ```java
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
    ```

## 1.2 队列
### 定义
  遵循**先进先出**的一种线性的**数据结构**。

### 应用实例1-数组模拟队列
