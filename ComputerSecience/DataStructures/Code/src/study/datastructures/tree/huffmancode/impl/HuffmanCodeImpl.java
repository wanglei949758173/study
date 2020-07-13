/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HuffmanCodeImpl.java 
 * 作者 王磊 
 * 编写日期 2020年07月13日 
 */
package study.datastructures.tree.huffmancode.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import study.datastructures.tree.huffmancode.HuffmanCode;
import study.datastructures.tree.huffmancode.HuffmanTreeNode;

public class HuffmanCodeImpl implements HuffmanCode {

	@Override
	public byte[] encode(byte[] originData) {
		// 转换为赫夫曼树节点
		List<HuffmanTreeNode<Byte>> nodes = toHuffmanTreeNodes(originData);
		System.out.println(nodes);
		
		// 构建赫夫曼树

		// 获取赫夫曼编码
		return null;
	}

	// 将原始数据转换为赫夫曼树节点
	private List<HuffmanTreeNode<Byte>> toHuffmanTreeNodes(byte[] originData) {
		// 统计每个字节出现的次数
		Map<Byte, Integer> byteCounter = new HashMap<Byte, Integer>();
		for (int i = 0; i < originData.length; i++) {
			byte currentByte = originData[i];
			Integer count = byteCounter.get(currentByte);
			if (count == 0) {
				byteCounter.put(currentByte, Integer.valueOf(1));
			} else {
				byteCounter.put(currentByte, count + 1);
			}
		}

		List<HuffmanTreeNode<Byte>> nodes = new ArrayList<>();
		// 转换为节点
		byteCounter.forEach((byteValue, count) -> {
			nodes.add(new HuffmanTreeNode<Byte>(byteValue, count));
		});
		return nodes;
	}
}
