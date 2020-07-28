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

	// 删除子节点
	public void deleteChildNode(int value) {
		// 找到要删除的节点targetNode
		Node targetNode = findNode(value);
		if (targetNode == null) {
			System.out.println("不存在要删除的节点,value=" + value);
			return;
		}

		// 找到targetNode的父节点parentNode
		Node parentNode = findParentNode(value);
		if (parentNode == null) {
			throw new IllegalStateException("该函数只提供删除子节点的功能");
		}

		// 删除的节点为叶子节点
		if (targetNode.left == null && targetNode.right == null) {
			deleteLeafNode(targetNode, parentNode);
		} else if (targetNode.left != null && targetNode.right != null) {
			// 删除的节点是有两颗子树的节点
			deleteHasTowSubTreeNode(targetNode, parentNode);
		} else {
			// 删除的节点是有一颗子树的节点
			// 判断删除的节点存在左子节点还是右子节点
			deleteHasOneSubTreeNode(targetNode, parentNode);
		}
	}

	// 查找节点
	private Node findNode(int value) {
		if (this.value == value) {
			return this;
		}

		if (value < this.value && this.left != null) {
			return this.left.findNode(value);
		} else if (value > this.value && this.right != null) {
			return this.right.findNode(value);
		}
		return null;
	}

	// 查找父节点
	private Node findParentNode(int value) {
		if ((this.left != null && this.left.value == value)
				|| (this.right != null && this.right.value == value)) {
			return this;
		}

		if (this.left != null && value < this.value) {
			return this.left.findParentNode(value);
		}

		if (this.right != null && value > this.value) {
			return this.right.findParentNode(value);
		}
		return null;
	}

	// 删除叶子节点
	private void deleteLeafNode(Node targetNode, Node parentNode) {
		// targetNode是parentNode的左子节点
		if (parentNode.left != null && parentNode.left == targetNode) {
			parentNode.left = null;
		} else {
			parentNode.right = null;
		}
	}

	// 删除只有一颗子树的节点
	private void deleteHasOneSubTreeNode(Node targetNode, Node parentNode) {
		if (targetNode.left != null) {
			if (parentNode.left == targetNode) {
				parentNode.left = targetNode.left;
			} else {
				parentNode.right = targetNode.left;
			}
		} else {
			if (parentNode.left == targetNode) {
				parentNode.left = targetNode.right;
			} else {
				parentNode.right = targetNode.right;
			}
		}
	}

	// 删除有两个子节点的节点
	private void deleteHasTowSubTreeNode(Node targetNode, Node parentNode) {
		// 删除右子树最小的节点
		Node minNode = deleteMinNode(targetNode.right);
		targetNode.value = minNode.value;
	}

	// 删除子树最小的节点
	public Node deleteMinNode(Node node) {
		Node minNode = node;
		while (minNode.left != null) {
			minNode = minNode.left;
		}
		deleteChildNode(minNode.value);
		return minNode;
	}
}
