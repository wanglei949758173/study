/*      
 * 模块编号  
 * 功能描述 
 * 文件名 SubExression.java 
 * 作者 王磊 
 * 编写日期 2020年05月27日 
 */
package test.pattern.action.interpreter.impl;

import java.util.Map;

import test.pattern.action.interpreter.AbstractExression;
import test.pattern.action.interpreter.SymbolExression;

public class SubExpression extends SymbolExression {

	public SubExpression(AbstractExression left, AbstractExression right) {
		super(left, right);
	}

	@Override
	public int interpreter(Map<String, Integer> var) {
		return left.interpreter(var) - right.interpreter(var);
	}

}
