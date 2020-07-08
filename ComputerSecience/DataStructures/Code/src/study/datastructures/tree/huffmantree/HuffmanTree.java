/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HuffmanTree.java 
 * 作者 王磊 
 * 编写日期 2020年07月08日 
 */
package study.datastructures.tree.huffmantree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HuffmanTree {
	/**
	 * 将数组构建成一个huffman树
	 * @param array	数组
	 * @return		huffman树
	 */
	public static Node buildHuffmanTree(int[] array) {
		// 数组转换为一个集合
		List<Node> nodeList =
				Arrays.stream(array)
					.mapToObj(value -> new Node(value))
					.collect(Collectors.toList());

		// 大于一个元素
		while (nodeList.size() > 1) {
			// 排序
			nodeList.sort((node1, node2) -> Integer.compare(node1.value, node2.value));
			// 取出前两个元素
			Node node1 = nodeList.get(0);
			Node node2 = nodeList.get(1);
			// 构建成一棵树
			Node newNode = new Node(node1.value + node2.value);
			newNode.left = node1;
			newNode.right = node2;
			// 删除前两个节点
			nodeList.remove(node1);
			nodeList.remove(node2);
			// 添加新的节点
			nodeList.add(newNode);
		}

		return nodeList.get(0);
	}
	
	public static void preOrder(Node node) {
		node.preOrder();
	}
}


