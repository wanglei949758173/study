/*      
 * 模块编号  
 * 功能描述 使用数组实现栈
 * 文件名 ArrayStack.java 
 * 作者 王磊 
 * 编写日期 2020年03月17日 
 */
package study.datastructures.list.stack.impl;

import study.datastructures.list.stack.Stack;

public class ArrayStack<T> implements Stack<T> {
	private Object[] datas;

	// top指针,指向栈顶元素
	private int top = -1;

	public ArrayStack(int size) {
		this.datas = new Object[size];
	}

	@Override
	public void push(T element) throws Exception {
		// 栈满
		if (full()) {
			throw new Exception("stack is full.");
		}

		this.top++;
		this.datas[this.top] = element;
	}

	@Override
	public T pop() throws Exception {
		// 栈空
		if (empty()) {
			throw new Exception("stack is empty.");
		}

		@SuppressWarnings("unchecked")
		T element = (T) this.datas[this.top];
		this.top--;
		return element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() throws Exception {
		// 栈空
		if (empty()) {
			throw new Exception("stack is empty.");
		}

		return (T) this.datas[this.top];
	}

	@Override
	public boolean empty() {
		return this.top == -1;
	}

	@Override
	public boolean full() {
		return this.top >= (this.datas.length - 1);
	}

	@Override
	public void show() {
		if (empty()) {
			System.out.println("stack is empty.");
		} else {
			for (int i = this.top; i > -1; i--) {
				System.out.println("datas[" + i + "] = " + this.datas[i]);
			}
		}
	}

}
