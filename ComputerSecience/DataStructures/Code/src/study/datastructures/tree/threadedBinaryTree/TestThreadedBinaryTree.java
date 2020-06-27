/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestThreadedBinaryTree.java 
 * 作者 王磊 
 * 编写日期 2020年06月27日 
 */
package study.datastructures.tree.threadedBinaryTree;

public class TestThreadedBinaryTree {
	public static void main(String[] args) {
		// 创建树
		Node root = new Node(1, "tom");
		Node node2 = new Node(3, "jack");
		Node node3 = new Node(6, "smith");
		Node node4 = new Node(8, "mary");
		Node node5 = new Node(10, "king");
		Node node6 = new Node(14, "dim");

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;

		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
		// 测试中序线索化
		threadedBinaryTree.threadedNodes();

		Node leftNode = node5.left;
		Node rightNode = node5.right;
		System.out.println("10号结点的前驱结点是 =" + leftNode); // 3
		System.out.println("10号结点的后继结点是=" + rightNode); // 1

		// 遍历
		threadedBinaryTree.list(); // 8,3,10,1,14,6
	}
}
