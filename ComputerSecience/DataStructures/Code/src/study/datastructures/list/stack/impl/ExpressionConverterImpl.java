/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ExpressionConverterImpl.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package study.datastructures.list.stack.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import study.datastructures.list.stack.ExpressionConverter;

public class ExpressionConverterImpl implements ExpressionConverter {

	@Override
	public String infixExpressionToSuffixExpression(String infixExpression) {
		// 表达式转为List
		List<String> expressionList = toList(infixExpression);
		// 符号栈
		Stack<String> symbolStack = new Stack<>();
		// 中间结果栈
		List<String> intermediateResultStack = new ArrayList<>();

		// // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2

		for (String currentChar : expressionList) {
			if (isNumber(currentChar)) {
				// 数字
				intermediateResultStack.add(currentChar);
			} else if (isSymbol(currentChar)) {
				// 操作符
				// 如果 symbolStack 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈
				if (symbolStack.isEmpty() || "(".equals(symbolStack.peek())) {
					symbolStack.push(currentChar);
				} else if (SymbolPriority.isGraterThan(currentChar, symbolStack.peek())) {
					// 若优先级比栈顶运算符的高，也将运算符压入 symbolStack
					symbolStack.push(currentChar);
				} else {
					while (!symbolStack.isEmpty()
							&& SymbolPriority.isGraterThan(symbolStack.peek(), currentChar)) {
						// 优先级小于等于符号栈栈顶元素
						// 将 symbolStack 栈顶的运算符弹出并压入到 intermediateResultStack 中
						// 再次转到(4.1)与 symbolStack 中新的栈顶运算符相比较
						intermediateResultStack.add(symbolStack.pop());
					}
					// 将当前符号压入栈
					symbolStack.push(currentChar);
				}
			} else if ("(".equals(currentChar)) {
				// 左括号
				symbolStack.push(currentChar);
			} else if (")".equals(currentChar)) {
				// 依次弹出 symbolStack 栈顶的运算符，并压入 intermediateResultStack，直到遇到左括号为止，此时将这一对括号丢弃
				String topSymbol = symbolStack.peek();
				while (!"(".equals(topSymbol)) {
					intermediateResultStack.add(symbolStack.pop());
					topSymbol = symbolStack.peek();
				}
				// 删除(
				symbolStack.pop();
			} else {
				throw new RuntimeException("非法字符：" + currentChar);
			}
		}

		// 将 symbolStack 中剩余的运算符依次弹出并压入 intermediateResultStack
		while (!symbolStack.isEmpty()) {
			intermediateResultStack.add(symbolStack.pop());
		}

		// 转为字符串
		StringBuilder sb = new StringBuilder();
		intermediateResultStack.forEach(currentRes -> {
			sb.append(currentRes);
			sb.append(" ");
		});
		return sb.toString();
	}

	/**
	 * 判断一个字符串是否为符号
	 * @param str	字符串
	 * @return		true-符号
	 * 				false-不是符号
	 */
	private boolean isSymbol(String str) {
		return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
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
	 * 将中缀表达式转为列表
	 * @param infixExpression	中缀表达式
	 * @return					中缀表达式列表
	 */
	private List<String> toList(String infixExpression) {
		String[] expressionArray = infixExpression.split(" ");
		return Arrays.stream(expressionArray).collect(Collectors.toList());
	}

}
