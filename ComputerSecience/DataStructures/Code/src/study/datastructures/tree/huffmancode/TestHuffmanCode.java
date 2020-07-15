/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestHuffmanCode.java 
 * 作者 王磊 
 * 编写日期 2020年07月14日 
 */
package study.datastructures.tree.huffmancode;

import study.datastructures.tree.huffmancode.impl.HuffmanCodeImpl;

public class TestHuffmanCode {
	public static void main(String[] args) {
		HuffmanCode coder = new HuffmanCodeImpl();
		String str = "i like like like java do you like a java";
		coder.encode(str.getBytes());
	}
}
