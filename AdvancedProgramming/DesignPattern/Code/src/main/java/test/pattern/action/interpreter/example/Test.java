/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Test.java 
 * 作者 王磊 
 * 编写日期 2020年05月28日 
 */
package test.pattern.action.interpreter.example;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {
	public static void main(String[] args) {
		SpelExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("2*3+4");
		Object value = expression.getValue();
		System.out.println(value);
	}
}
