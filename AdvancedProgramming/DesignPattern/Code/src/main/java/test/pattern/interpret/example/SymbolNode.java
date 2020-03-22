/*      
 * 模块编号  
 * 功能描述 符号节点
 * 文件名 SymbolNode.java  
 * 作者 王磊 
 * 编写日期 2019年5月23日    
 */
package test.pattern.interpret.example;

/**
 * 符号节点
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public abstract class SymbolNode implements Node {
	protected Node left;
	protected Node right;

	public SymbolNode(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
}
