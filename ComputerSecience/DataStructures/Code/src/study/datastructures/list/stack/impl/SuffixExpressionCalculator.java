/*      
 * 模块编号  
 * 功能描述 
 * 文件名 SuffixExpressionCalculator.java 
 * 作者 王磊 
 * 编写日期 2020年03月28日 
 */
package study.datastructures.list.stack.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import study.datastructures.list.stack.ExpressionCalculator;

/**
 * 后缀表达式计算器
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class SuffixExpressionCalculator implements ExpressionCalculator {

	@Override
	public int calculate(String suffixExpression) throws Exception {
		// 先定义给逆波兰表达式
		// (30+4)×5-6 => 30 4 + 5 × 6 - => 164
		// 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2
		List<String> suffixExpressionList = suffixExpressionToList(suffixExpression);
		return doCalculate(suffixExpressionList);
	}

	/**
	 * 后缀表达式转成list
	 * @param suffixExpression	后缀表达式
	 * @return					字符串列表
	 */
	private List<String> suffixExpressionToList(String suffixExpression) {
		String[] expressioArray = suffixExpression.split(" ");
		List<String> expressioList = Arrays.stream(expressioArray).collect(Collectors.toList());
		return expressioList;
	}

	/**
	 * 计算后缀表达式列表的值
	 * @param suffixExpressionList		后缀表达式列表
	 * @return							后缀表达式列表的值
	 */
	private int doCalculate(List<String> suffixExpressionList) {
		// 创建一个栈，用于存放数字和符号
		Stack<String> stack = new Stack<>();

		suffixExpressionList.forEach(currentStr -> {
			if (isNumber(currentStr)) {
				// 遇到数字,将数字入栈
				stack.push(currentStr);
			} else {
				// 遇到符号，计算栈顶两个元素的值，将运算结果放入栈中
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int calculateRes = calculate(num1, num2, currentStr);
				stack.push(String.valueOf(calculateRes));
			}
		});

		// 栈顶元素为最终的计算结果
		return Integer.parseInt(stack.pop());
	}

	/**
	 * 判断一个字符串是否为数字
	 * @param str		字符串
	 * @return			true-是数字
	 * 					false-不是数字
	 */
	private boolean isNumber(String str) {
		return str.matches("\\d+");
	}

	/**
	 * 计算两个数的值
	 * @param num1		数字1
	 * @param num2		数字2
	 * @param symbol	符号
	 * @return			计算后的值
	 */
	private int calculate(Integer num1, Integer num2, String symbol) {
		if ("+".equals(symbol)) {
			return num1 + num2;
		} else if ("-".equals(symbol)) {
			return num2 - num1;
		} else if ("*".equals(symbol)) {
			return num1 * num2;
		} else if ("/".equals(symbol)) {
			return num2 / num1;
		} else {
			throw new RuntimeException("非法的操作符：" + symbol);
		}
	}
}
