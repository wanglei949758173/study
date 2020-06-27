/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ThreadBinaryTree.java 
 * 作者 王磊 
 * 编写日期 2020年06月27日 
 */
package study.datastructures.tree.threadedBinaryTree;

public class ThreadedBinaryTree {
	// 根节点
	private Node root;

	// 前一个节点
	private Node preNode;

	public ThreadedBinaryTree(Node root) {
		this.root = root;
	}

	// 线索化二叉树
	public void threadedNodes() {
		threadedNodes(root);
	}

	/**
	 * 将node为根的子树中序线索化
	 * @param node	子树跟节点
	 */
	protected void threadedNodes(Node node) {
		if (node == null) {
			return;
		}

		// 线索化左子树
		threadedNodes(node.left);

		// 左子树为空,进行线索化
		if (node.left == null) {
			node.left = preNode;
			node.leftNodeType = Node.PREV_NODE_TYPE;
		}

		// 右子树为空,线索化前一个节点的右子树
		if (preNode != null && preNode.right == null) {
			preNode.right = node;
			preNode.rightNodeType = Node.NEXT_NODE_TYPE;
		}

		preNode = node;

		// 线索化右子树
		threadedNodes(node.right);
	}

	// 遍历线索化二叉树
	public void list() {
		Node currentNode = root;
		while (currentNode != null) {
			// 找到第一个节点
			while (currentNode.leftNodeType == Node.SUB_TREE_TYPE) {
				currentNode = currentNode.left;
			}
			
			// 输出第一个节点
			System.out.println(currentNode);
			
			// 遍历
			while (currentNode.rightNodeType == Node.NEXT_NODE_TYPE) {
				System.out.println(currentNode.right);
				currentNode = currentNode.right;
			}
			
			currentNode = currentNode.right;
		}
	}
}

class Node {
	// 节点类型-子树
	public static final int SUB_TREE_TYPE = 0;

	// 节点类型-前驱节点
	public static final int PREV_NODE_TYPE = 1;

	// 节点类型-后继节点
	public static final int NEXT_NODE_TYPE = 2;

	public int id;
	public String name;
	public Node left;
	public Node right;
	public int leftNodeType = Node.SUB_TREE_TYPE;
	public int rightNodeType = Node.SUB_TREE_TYPE;

	public Node(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + "]";
	}
}
