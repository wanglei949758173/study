/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ArrayBinaryTree.java 
 * 作者 王磊 
 * 编写日期 2020年06月24日 
 */
package study.datastructures.tree;

public class ArrayBinaryTree {
	private int[] nodes;

	public ArrayBinaryTree(int[] nodes) {
		this.nodes = nodes;
	}

	/**
	 * 前序遍历
	 */
	public void preOrder() {
		preOrder(0);
	}
	
	/**
	 * 前序遍历
	 * @param index		开始遍历的节点的索引
	 */
	protected void preOrder(int index) {
		// 输出当前元素
		System.out.println(nodes[index]);

		// 左递归
		int leftNodeIndex = 2 * index + 1;
		if (leftNodeIndex < nodes.length) {
			preOrder(leftNodeIndex);
		}
		
		// 右递归
		int rightNodeIndex = 2 * index + 2;
		if (rightNodeIndex < nodes.length) {
			preOrder(rightNodeIndex);
		}
	}
}
