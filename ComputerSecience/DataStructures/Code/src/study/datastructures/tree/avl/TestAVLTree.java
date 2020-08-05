/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestAVLTree.java 
 * 作者 王磊 
 * 编写日期 2020年08月05日 
 */
package study.datastructures.tree.avl;

public class TestAVLTree {
	public static void main(String[] args) {
		// 10, 12, 8, 9, 7, 6
		Node root = new Node(10);
		AVLTree avlTree = new AVLTree(root);
		avlTree.add(new Node(12));
		avlTree.add(new Node(8));
		avlTree.add(new Node(9));
		avlTree.add(new Node(7));
		avlTree.add(new Node(6));
		
		System.out.println(String.format("树高度=%s", avlTree.height()));
		System.out.println(String.format("左子树高度=%s", avlTree.leftHeight()));
		System.out.println(String.format("右子树高度=%s", avlTree.rightHeight()));
	}
}
