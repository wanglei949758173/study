/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HuffmanTreeNode.java 
 * 作者 王磊 
 * 编写日期 2020年07月13日 
 */
package study.datastructures.tree.huffmancode;

public class HuffmanTreeNode<T> implements Comparable<HuffmanTreeNode<T>> {
	// 数据
	private T data;

	// 权值
	private int weight;

	// 左子节点
	public HuffmanTreeNode<T> left;

	// 右子节点
	public HuffmanTreeNode<T> right;

	public HuffmanTreeNode(T data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "HuffmanTreeNode [data=" + data + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(HuffmanTreeNode<T> other) {
		return Integer.compare(this.weight, other.weight);
	}
}
