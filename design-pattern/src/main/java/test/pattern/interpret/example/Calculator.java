/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Calculator.java  
 * 作者 王磊 
 * 编写日期 2019年5月23日    
 */
package test.pattern.interpret.example;

import java.util.Stack;

/**
 * 计算器
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Calculator {
	private Node node;

	public void build(String statement) {
		Node left = null;
		Node right = null;
		Stack<Node> stack = new Stack<>();

		String[] statementArr = statement.split(" ");

		for (int i = 0; i < statementArr.length; i++) {
			if (statementArr[i].equalsIgnoreCase("*")) {
				left = (Node) stack.pop();
				int val = Integer.parseInt(statementArr[++i]);
				right = new ValueNode(val);
				stack.push(new MulNode(left, right));
			} else if (statementArr[i].equalsIgnoreCase("/")) {
				left = (Node) stack.pop();
				int val = Integer.parseInt(statementArr[++i]);
				right = new ValueNode(val);
				stack.push(new DivNode(left, right));
			} else if (statementArr[i].equalsIgnoreCase("%")) {
				left = (Node) stack.pop();
				int val = Integer.parseInt(statementArr[++i]);
				right = new ValueNode(val);
				stack.push(new ModNode(left, right));
			} else {
				stack.push(new ValueNode(Integer.parseInt(statementArr[i])));
			}
		}
		this.node = (Node) stack.pop();
	}

	public int compute() {
		return node.interpret();
	}
}
