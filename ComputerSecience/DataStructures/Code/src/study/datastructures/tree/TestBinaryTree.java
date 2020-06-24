/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestBinaryTree.java 
 * 作者 王磊 
 * 编写日期 2020年06月14日 
 */
package study.datastructures.tree;

public class TestBinaryTree {
	public static void main(String[] args) {
		// Node root = new Node(1, "宋江");
		// Node node2 = new Node(2, "吴用");
		// Node node3 = new Node(3, "卢俊义");
		// Node node4 = new Node(4, "林冲");
		// Node node5 = new Node(5, "关胜");

		// BinaryTree binaryTree = new BinaryTree(root);
		// root.left = node2;
		// root.right = node3;
		// node3.left = node5;
		// node3.right = node4;

		/*// 前序遍历
		System.out.println("前序遍历：");
		binaryTree.preOrder();// 1,2,3,5,4
		
		System.out.println();
		
		System.out.println("中序遍历：");
		binaryTree.infixOrder();// 2,1,5,3,4
		
		System.out.println("后序遍历：");
		binaryTree.postOrder();// 2,5,4,3,1
		*/

		// 前序查找
		// Node preSerarchResult = binaryTree.preSearch(5);
		// Node infixSerarchResult = binaryTree.infixSearch(5);
		// Node postSerarchResult = binaryTree.postSearch(5);
		// System.out.println(preSerarchResult);
		// System.out.println(infixSerarchResult);
		// System.out.println(postSerarchResult);

		// 删除前
		// System.out.println("删除前：");
		// binaryTree.preOrder(); // 1,2,3,5,4
		//
		// System.out.println();

		// 删除后
		// System.out.println("删除5后：");
		// binaryTree.remove(5);
		// binaryTree.preOrder(); // 1,2,3,4
		// System.out.println("删除3后：");
		// binaryTree.remove(3);
		// binaryTree.preOrder(); // 1,2

		int[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayBinaryTree tree = new ArrayBinaryTree(nodes);
		tree.preOrder(); // 1,2,4,5,3,6,7
	}
}
