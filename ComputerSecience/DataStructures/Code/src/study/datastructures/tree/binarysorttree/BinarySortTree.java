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

	// 删除节点
	public void delete(int value) {
		if (this.root == null) {
			System.out.println("当前二叉排序树为null");
			return;
		}

		// 删除的是根节点
		if (this.root.value == value) {
			// 无子节点
			if (this.root.left == null && this.root.right == null) {
				this.root = null;
			} else if (this.root.left != null && this.root.right != null) {
				// 有两个子节点
				// 找右子树最小的节点
				Node minNode = this.root.deleteMinNode(this.root.right);
				this.root.value = minNode.value;
			} else {
				// 只有一个子节点
				if (this.root.left != null) {
					this.root = this.root.left;
				} else {
					this.root = this.root.right;
				}
			}
			return;
		}

		this.root.deleteChildNode(value);
	}
}
