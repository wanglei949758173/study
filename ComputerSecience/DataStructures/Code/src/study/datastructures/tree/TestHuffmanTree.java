/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestHuffmanTree.java 
 * 作者 王磊 
 * 编写日期 2020年07月08日 
 */
package study.datastructures.tree;

import study.datastructures.tree.huffmantree.HuffmanTree;
import study.datastructures.tree.huffmantree.Node;

public class TestHuffmanTree {
	public static void main(String[] args) {
		int[] array = {13, 7, 8, 3, 29, 6, 1};
		Node node = HuffmanTree.buildHuffmanTree(array);
		HuffmanTree.preOrder(node);
	}
}
