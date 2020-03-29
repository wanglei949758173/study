/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestSuffixExpressionCalculator.java 
 * 作者 王磊 
 * 编写日期 2020年03月28日 
 */
package study.datastructures.list.stack;

import study.datastructures.list.stack.impl.ExpressionConverterImpl;
import study.datastructures.list.stack.impl.SuffixExpressionCalculator;

public class TestSuffixExpressionCalculator {
	public static void main(String[] args) throws Exception {
		String expression1 = "( 30 + 4 ) * 5 - 6";
		String expression2 = "( 26 + 6 ) * 3 / 3 + 9 - 2 - 4 / 2 + 3";
		
		// 转换为后缀表达式
		ExpressionConverter converter = new ExpressionConverterImpl();
		String suffixExpression1 = converter.infixExpressionToSuffixExpression(expression1);
		String suffixExpression2 = converter.infixExpressionToSuffixExpression(expression2);
		
		// 计算后缀表达式的值
		ExpressionCalculator expressionCalculator = new SuffixExpressionCalculator();
		int res1 = expressionCalculator.calculate(suffixExpression1);
		int res2 = expressionCalculator.calculate(suffixExpression2);
		
		// 打印结果
		System.out.printf("%s = %d\r\n", expression1, res1);
		System.out.printf("%s = %d\r\n", expression2, res2);
	}
}
