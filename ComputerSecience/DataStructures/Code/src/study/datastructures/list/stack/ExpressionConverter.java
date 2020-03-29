/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ExpressionParser.java 
 * 作者 王磊 
 * 编写日期 2020年03月28日 
 */
package study.datastructures.list.stack;

/**
 * 表达式转换器
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public interface ExpressionConverter {
	/**
	 * 中缀表达式转为后缀表达式
	 * @param infixExpression	中缀表达式
	 * @return					后缀表达式
	 */
	String infixExpressionToSuffixExpression(String infixExpression);
}
