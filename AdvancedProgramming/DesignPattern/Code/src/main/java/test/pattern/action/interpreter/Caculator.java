/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Caculator.java 
 * 作者 王磊 
 * 编写日期 2020年05月27日 
 */
package test.pattern.action.interpreter;

import java.util.Map;
import java.util.Stack;

import test.pattern.action.interpreter.impl.AddExression;
import test.pattern.action.interpreter.impl.SubExpression;
import test.pattern.action.interpreter.impl.VarExpression;

public class Caculator {
	/**
	 * 计算表达式的值
	 * @param expressionStr		表达式
	 * @param var				表达式变量对应的值
	 * @return					计算的结果
	 */
	public int compute(String expressionStr, Map<String, Integer> var) {
		char[] expChars = expressionStr.toCharArray();

		Stack<AbstractExression> stack = new Stack<>();
		// 构造表达式
		for (int i = 0; i < expChars.length; i++) {
			char currentExpChar = expChars[i];
			AbstractExression leftExression = null;
			AbstractExression rightExression = null;
			String nextVar = null;
			switch (currentExpChar) {
			case '+':
				leftExression = stack.pop();
				nextVar = String.valueOf(expChars[++i]);
				rightExression = new VarExpression(nextVar);
				stack.push(new AddExression(leftExression, rightExression));
				break;
			case '-':
				leftExression = stack.pop();
				nextVar = String.valueOf(expChars[++i]);
				rightExression = new VarExpression(nextVar);
				stack.push(new SubExpression(leftExression, rightExression));
				break;
			default:
				stack.push(new VarExpression(String.valueOf(currentExpChar)));
				break;
			}
		}
		AbstractExression exression = stack.pop();

		// 计算值
		return exression.interpreter(var);
	}
}
