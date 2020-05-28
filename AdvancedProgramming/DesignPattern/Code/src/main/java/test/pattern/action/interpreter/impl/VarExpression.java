/*      
 * 模块编号  
 * 功能描述 
 * 文件名 VarExpression.java 
 * 作者 王磊 
 * 编写日期 2020年05月27日 
 */
package test.pattern.action.interpreter.impl;

import java.util.Map;

import test.pattern.action.interpreter.AbstractExression;

public class VarExpression extends AbstractExression{
	private String varKey;
	
	public VarExpression(String varKey) {
		super();
		this.varKey = varKey;
	}

	@Override
	public int interpreter(Map<String, Integer> var) {
		return var.get(varKey);
	}

}
