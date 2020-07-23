/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestHuffmanCode.java 
 * 作者 王磊 
 * 编写日期 2020年07月14日 
 */
package study.datastructures.tree.huffmancode;

import java.util.Arrays;

import study.datastructures.tree.huffmancode.impl.HuffmanCodeImpl;

public class TestHuffmanCode {
	public static void main(String[] args) {
		HuffmanCode coder = new HuffmanCodeImpl();
		String str = "i like like like java do you like java a";
		byte[] code = coder.encode(str.getBytes());

		System.out.println("压缩后的结果：");
		System.out.println(Arrays.toString(code));

		// 解压
		byte[] originalData = coder.decode(code);
		System.out.println(new String(originalData));
	}
}
