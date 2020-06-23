/*      
 * 模块编号  
 * 功能描述 
 * 文件名 BinaryTree.java 
 * 作者 王磊 
 * 编写日期 2020年06月14日 
 */
package study.datastructures.tree;

public class BinaryTree {
	// 根节点
	private Node root;

	public BinaryTree(Node root) {
		this.root = root;
	}

	// 前序遍历
	public void preOrder() {
		this.root.preOrder();
	}

	// 中序遍历
	public void infixOrder() {
		this.root.infixOrder();
	}

	// 后序遍历
	public void postOrder() {
		this.root.postOrder();
	}

	// 前序查找
	public Node preSearch(int id) {
		return this.root.preSearch(id);
	}

	// 中序查找
	public Node infixSearch(int id) {
		return this.root.infixSearch(id);
	}

	// 后序查找
	public Node postSearch(int id) {
		return this.root.postSearch(id);
	}

	/**
	 * 根据Id删除节点
	 * @param id	待删除节点的id
	 */
	public void remove(int id) {
		if (this.root.id == id) {
			this.root = null;
		} else {
			this.root.removeChildNode(id);
		}
	}
}

class Node {
	public int id;
	public String name;
	public Node left;
	public Node right;

	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + "]";
	}

	// 前序遍历
	public void preOrder() {
		// 输出当前节点
		System.out.println(this);
		// 如果左节点不为null，递归遍历左节点
		if (this.left != null) {
			this.left.preOrder();
		}
		// 如果右节点不为null，递归遍历右节点
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 中序遍历
	public void infixOrder() {
		// 如果左节点不为null，递归遍历左节点
		if (this.left != null) {
			this.left.infixOrder();
		}
		// 输出当前节点
		System.out.println(this);
		// 如果右节点不为null，递归遍历右节点
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// 后序遍历
	public void postOrder() {
		// 如果左节点不为null，递归遍历左节点
		if (this.left != null) {
			this.left.postOrder();
		}
		// 如果右节点不为null，递归遍历右节点
		if (this.right != null) {
			this.right.postOrder();
		}
		// 输出当前节点
		System.out.println(this);
	}

	// 前序查找
	public Node preSearch(int id) {
		System.out.println("前序查找");
		// 和当前节点比较
		if (this.id == id) {
			return this;
		}

		// 左递归
		if (this.left != null) {
			Node searchResult = this.left.preSearch(id);
			if (searchResult != null) {
				return searchResult;
			}
		}

		// 右递归
		if (this.right != null) {
			Node searchResult = this.right.preSearch(id);
			if (searchResult != null) {
				return searchResult;
			}
		}

		return null;
	}

	// 中序查找
	public Node infixSearch(int id) {
		// 左递归
		if (this.left != null) {
			Node searchResult = this.left.infixSearch(id);
			if (searchResult != null) {
				return searchResult;
			}
		}

		System.out.println("中序查找");
		// 和当前节点比较
		if (this.id == id) {
			return this;
		}

		// 右递归
		if (this.right != null) {
			Node searchResult = this.right.infixSearch(id);
			if (searchResult != null) {
				return searchResult;
			}
		}

		return null;
	}

	// 后序查找
	public Node postSearch(int id) {
		// 左递归
		if (this.left != null) {
			Node searchResult = this.left.postSearch(id);
			if (searchResult != null) {
				return searchResult;
			}
		}

		// 右递归
		if (this.right != null) {
			Node searchResult = this.right.postSearch(id);
			if (searchResult != null) {
				return searchResult;
			}
		}

		System.out.println("后序查找");
		// 和当前节点比较
		if (this.id == id) {
			return this;
		}
		return null;
	}

	/**
	 * 根据Id删除节点
	 * @param id	待删除节点的id
	 */
	public void removeChildNode(int id) {
		// 左子树为要删除的节点
		if (this.left != null && this.left.id == id) {
			this.left = null;
			return;
		}

		// 右子树为要删除的节点
		if (this.right != null && this.right.id == id) {
			this.right = null;
			return;
		}

		// 左递归
		if (this.left != null) {
			this.left.removeChildNode(id);
		}

		// 右递归
		if (this.right != null) {
			this.right.removeChildNode(id);
		}
	}
}
