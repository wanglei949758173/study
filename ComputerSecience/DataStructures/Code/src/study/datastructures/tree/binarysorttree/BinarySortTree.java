/*      
 * 模块编号  
 * 功能描述 
 * 文件名 BinarySortTree.java 
 * 作者 王磊 
 * 编写日期 2020年07月23日 
 */
package study.datastructures.tree.binarysorttree;

public class BinarySortTree {
	// 根节点
	private Node root;

	public BinarySortTree(Node root) {
		this.root = root;
	}

	// 添加节点
	public void add(Node node) {
		if (this.root == null) {
			this.root = node;
		} else {
			this.root.add(node);
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root == null) {
			System.out.println("二叉排序树为空");
		} else {
			this.root.infixOrder();
		}
	}
}
