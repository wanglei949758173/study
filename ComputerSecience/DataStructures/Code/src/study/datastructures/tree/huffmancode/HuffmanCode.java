/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HuffmanCode.java 
 * 作者 王磊 
 * 编写日期 2020年07月13日 
 */
package study.datastructures.tree.huffmancode;

public interface HuffmanCode {
	/**
	 * 压缩编码
	 * @param originData 原始数据
	 * @return			   经过赫夫曼编码的数据
	 */
	byte[] encode(byte[] originData);
}
