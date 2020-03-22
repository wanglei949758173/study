/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestSimpleExpressionCalculator.java 
 * 作者 王磊 
 * 编写日期 2020年03月18日 
 */
package study.datastructures.list.stack;

import study.datastructures.list.stack.impl.SimpleExpressionCalculator;

public class TestSimpleExpressionCalculator {
	public static void main(String[] args) throws Exception {
		ExpressionCalculator expressionCalculator = new SimpleExpressionCalculator();
		String expression1 = "3+3*6-8";
		int res1 = expressionCalculator.calculate(expression1);
		System.out.printf("%s=%d\r\n", expression1, res1);
		String expression2 = "12/6+6-7*100+0";
		int res2 = expressionCalculator.calculate(expression2);
		System.out.printf("%s=%d\r\n", expression2, res2);
	}
}
