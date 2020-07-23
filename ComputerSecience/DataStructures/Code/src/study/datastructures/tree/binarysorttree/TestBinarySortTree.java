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
		// 7, 3, 10, 12, 5, 1, 9
		Node root = new Node(7);
		BinarySortTree bst = new BinarySortTree(root);
		bst.add(new Node(3));
		bst.add(new Node(10));
		bst.add(new Node(12));
		bst.add(new Node(5));
		bst.add(new Node(1));
		bst.add(new Node(9));
		
		bst.infixOrder();
	}
}
