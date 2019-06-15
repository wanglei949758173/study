/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ValueNode.java  
 * 作者 王磊 
 * 编写日期 2019年5月23日    
 */
package test.pattern.interpret.example;

/**
 * 值节点，终极节点
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class ValueNode implements Node {
	private int value;
	
	public ValueNode(int v) {
		this.value = v;
	}

	@Override
	public int interpret() {
		return this.value;
	}

}
