/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestBinarySortTree.java 
 * 作者 王磊 
 * 编写日期 2020年07月23日 
 */
package study.datastructures.tree.binarysorttree;

public class TestBinarySortTree {
	public static void main(String[] args) {
		// 7, 3, 10, 1, 5, 9, 12, 2
		Node root = new Node(7);
		BinarySortTree bst = new BinarySortTree(root);
		bst.add(new Node(3));
		bst.add(new Node(10));
		bst.add(new Node(1));
		bst.add(new Node(5));
		bst.add(new Node(9));
		bst.add(new Node(12));
		bst.add(new Node(2));
		
		
		bst.delete(7);
		bst.delete(9);
		bst.delete(3);
		bst.delete(5);
		bst.delete(1);
		bst.delete(2);
		bst.delete(12);
		bst.delete(10);
		bst.infixOrder();
	}
}
