/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Node.java 
 * 作者 王磊 
 * 编写日期 2020年07月23日 
 */
package study.datastructures.tree.binarysorttree;

public class Node {
	// 节点的值
	public int value;

	// 左子节点
	public Node left;

	// 右子节点
	public Node right;

	public Node(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	// 添加节点
	public void add(Node node) {
		// 小于,往左放
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			// 大于等于,往右放
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}

		System.out.println(this);

		if (this.right != null) {
			this.right.infixOrder();
		}
	}
}
