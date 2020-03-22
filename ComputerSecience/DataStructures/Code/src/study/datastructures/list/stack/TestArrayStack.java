/*      
 * 模块编号  
 * 功能描述 测试数组栈
 * 文件名 TestArrayStack.java 
 * 作者 王磊 
 * 编写日期 2020年03月17日 
 */
package study.datastructures.list.stack;

import java.util.Scanner;

import study.datastructures.list.stack.impl.ArrayStack;

public class TestArrayStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayStack<>(4);

		boolean loop = true;
		while (loop) {
			System.out.println("===============================");
			System.out.println("欢迎测试");
			System.out.println("===============================");
			System.out.println("push-入栈");
			System.out.println("pop-出栈");
			System.out.println("peek-查看栈顶元素");
			System.out.println("exit-退出程序");

			// 读取用户输入的选项
			Scanner scanner = new Scanner(System.in);
			String inputOption = scanner.next();
			try {
				switch (inputOption) {
				case "push":
					System.out.println("Please input a number:");
					String inputNumber = scanner.next();
					stack.push(Integer.parseInt(inputNumber));
					stack.show();
					break;
				case "pop":
					stack.pop();
					stack.show();
					break;
				case "peek":
					System.out.printf("栈顶元素是：%d\r\n", stack.peek());
					break;
				case "exit":
					scanner.close();
					loop = false;
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		}

		System.out.println("App is stop.");
	}
}
