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
    ![稀疏数组应用实例](https://github.com/wanglei949758173/study/blob/master/ComputerSecience/DataStructures/Images/sparsearray/sparsearray-1.jpg)
  * 思路分析
    ![思路分析](https://github.com/wanglei949758173/study/blob/master/ComputerSecience/DataStructures/Images/sparsearray/sparsearray-2.jpg)
  * 代码实现 <br/>
    <a target="_blank" href="https://github.com/wanglei949758173/study/blob/master/ComputerSecience/DataStructures/Code/src/study/datastructures/list/SparseArray.java">稀疏数组代码示例</a>
