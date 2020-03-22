/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MulNode.java  
 * 作者 王磊 
 * 编写日期 2019年5月23日    
 */
package test.pattern.interpret.example;

/**
 * 乘法节点
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class MulNode extends SymbolNode {

	public MulNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public int interpret() {
		return left.interpret() * right.interpret();
	}

}
