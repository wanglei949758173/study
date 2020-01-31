/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ModNode.java  
 * 作者 王磊 
 * 编写日期 2019年5月23日    
 */
package test.pattern.interpret.example;

/**
 * 取模节点
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class ModNode extends SymbolNode {

	public ModNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public int interpret() {
		return left.interpret() % right.interpret();
	}

}
