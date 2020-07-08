package study.datastructures.tree.huffmantree;
public class Node {
	// 权值
	int value;
	// 左节点
	Node left;
	// 右节点
	Node right;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		// 左递归
		if (this.left != null) {
			this.left.preOrder();
		}
		// 右递归
		if (this.right != null) {
			this.right.preOrder();
		}
	}
}