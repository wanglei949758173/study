/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HuffmanCodeImpl.java 
 * 作者 王磊 
 * 编写日期 2020年07月13日 
 */
package study.datastructures.tree.huffmancode.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import study.datastructures.tree.huffmancode.HuffmanCode;
import study.datastructures.tree.huffmancode.HuffmanTreeNode;

public class HuffmanCodeImpl implements HuffmanCode {

	private Map<Byte, String> huffmanCode;

	@Override
	public byte[] encode(byte[] originData) {
		// 转换为赫夫曼树节点
		List<HuffmanTreeNode<Byte>> nodes = toHuffmanTreeNodes(originData);

		// 构建赫夫曼树
		HuffmanTreeNode<Byte> huffmanTree = buildHuffmanTree(nodes);

		// 生成赫夫曼编码
		Map<Byte, String> huffmanCode = generateHuffmanCode(huffmanTree);
		this.huffmanCode = huffmanCode;

		// 进行编码
		return doEncode(originData, huffmanCode);
	}

	// 将原始数据转换为赫夫曼树节点
	private List<HuffmanTreeNode<Byte>> toHuffmanTreeNodes(byte[] originData) {
		// 统计每个字节出现的次数
		Map<Byte, Integer> byteCounter = new HashMap<Byte, Integer>();
		for (int i = 0; i < originData.length; i++) {
			byte currentByte = originData[i];
			Integer count = byteCounter.get(currentByte);
			if (count == null) {
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

	// 将给定的节点构建成一颗赫夫曼树
	private HuffmanTreeNode<Byte> buildHuffmanTree(List<HuffmanTreeNode<Byte>> nodes) {
		while (nodes.size() > 1) {
			// 排序
			Collections.sort(nodes);

			// 取前两个节点
			HuffmanTreeNode<Byte> node1 = nodes.get(0);
			HuffmanTreeNode<Byte> node2 = nodes.get(1);

			// 构建节点
			HuffmanTreeNode<Byte> newNode =
					new HuffmanTreeNode<Byte>(null, node1.getWeight() + node2.getWeight());
			newNode.left = node1;
			newNode.right = node2;

			// 添加新节点,删除旧节点
			nodes.add(newNode);
			nodes.remove(node1);
			nodes.remove(node2);
		}
		return nodes.get(0);
	}

	// 根据赫夫曼树生成每个字节的赫夫曼编码
	private Map<Byte, String> generateHuffmanCode(HuffmanTreeNode<Byte> huffmanTree) {
		Map<Byte, String> huffmanCode = new HashMap<>();

		// 获取左子节点的所有叶子节点的编码
		getCodes(huffmanTree.left, "0", new StringBuilder(), huffmanCode);
		// 获取右子节点的所有叶子节点的编码
		getCodes(huffmanTree.right, "1", new StringBuilder(), huffmanCode);
		return huffmanCode;
	}

	// 获取一个节点的的编码
	private void getCodes(HuffmanTreeNode<Byte> node,
			String code,
			StringBuilder prevNodeHuffmanCode,
			Map<Byte, String> huffmanCode) {
		StringBuilder codeBuilder = new StringBuilder(prevNodeHuffmanCode);
		codeBuilder.append(code);

		if (node == null) {
			return;
		}

		// 叶子节点
		if (node.getData() != null) {
			huffmanCode.put(node.getData(), codeBuilder.toString());
			return;
		}

		// 非叶子节点
		getCodes(node.left, "0", codeBuilder, huffmanCode);

		getCodes(node.right, "1", codeBuilder, huffmanCode);

	}

	// 根据原始数据和赫夫曼编码进行最终的编码
	private byte[] doEncode(byte[] originData, Map<Byte, String> huffmanCode) {
		StringBuilder codeBuilder = new StringBuilder();
		for (int i = 0; i < originData.length; i++) {
			byte currentByte = originData[i];
			String code = huffmanCode.get(currentByte);
			codeBuilder.append(code);
		}
		
		return toBytes(codeBuilder.toString());
	}

	// 将二进制字符串转换为字节数组
	private byte[] toBytes(String binaryString) {
		int length = binaryString.length() / 8;
		if (binaryString.length() % 8 != 0) {
			length += 1;
		}

		byte[] bytes = new byte[length];
		for (int i = 0; i < bytes.length; i++) {
			// 最后一个字节
			int start = i * 8;
			int end = start + 8;

			// 非最后一个字节
			if (i < bytes.length - 1) {
			} else {
				end = binaryString.length();
			}
			String byteStr = binaryString.substring(start, end);
			bytes[i] = (byte) Integer.parseInt(byteStr, 2);
		}
		return bytes;
	}

	@Override
	public byte[] decode(byte[] code) {
		if (this.huffmanCode == null) {
			throw new IllegalStateException("未压缩,还不能解压");
		}

		// 转为二进制字符串
		String binaryString = toBinaryString(code);

		// 根据赫夫曼编码还原
		Map<String, Byte> huffmanCodeMap = new HashMap<>();
		this.huffmanCode.forEach((value, binaryStr) -> {
			huffmanCodeMap.put(binaryStr, value);
		});

		return revert(huffmanCodeMap, binaryString);
	}

	// 将字节数组转换为二进制字符串
	private String toBinaryString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			// 转为补码
			byte currentByte = bytes[i];
			int byteIntValue = Byte.toUnsignedInt(currentByte);
			
			// 最后一个字节,无须补高位
			if (i == bytes.length - 1) {
				String binaryString = Integer.toBinaryString(byteIntValue);
				sb.append(binaryString);
			} else {
				// 补高位
				byteIntValue = byteIntValue | 256;
				String binaryString = Integer.toBinaryString(byteIntValue);
				sb.append(binaryString.substring(binaryString.length() - 8));
			}
		}
		return sb.toString();
	}

	// 根据赫夫曼编码和二进制字符串还原编码
	private byte[] revert(Map<String, Byte> huffmanCodeMap, String binaryString) {
		int tempIndex = 0;
		StringBuilder tempString = new StringBuilder();
		List<Byte> result = new ArrayList<>();
		while (tempIndex <= binaryString.length() - 1) {
			tempString.append(binaryString.charAt(tempIndex));
			Byte byteValue = huffmanCodeMap.get(tempString.toString());
			// 匹配到
			if (byteValue != null) {
				result.add(byteValue);
				tempString.delete(0, tempString.length());
			} else {
				// 未匹配到
			}
			tempIndex++;
		}

		byte[] bytes = new byte[result.size()];
		for (int i = 0; i < result.size(); i++) {
			Byte b = result.get(i);
			bytes[i] = b;

		}
		return bytes;
	}
}
