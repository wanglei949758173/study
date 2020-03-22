/*      
 * 模块编号  
 * 功能描述 提供栈的相关接口
 * 文件名 Stach.java 
 * 作者 王磊 
 * 编写日期 2020年03月17日 
 */
package study.datastructures.list.stack;

public interface Stack<T> {

	/**
	 * 将元素入栈
	 * @param element	元素
	 * @throws Exception
	 */
	void push(T element) throws Exception;

	/**
	 * 出栈
	 * @return		栈顶元素
	 * @throws Exception
	 */
	T pop() throws Exception;

	/**
	 * 查看栈顶元素
	 * @return	栈顶元素
	 * @throws Exception
	 */
	T peek() throws Exception;
	
	/**
	 * 判断栈是否为空
	 * @return	true-为空
	 * 			false-不为空
	 */
	boolean empty();
	
	/**
	 * 判断栈是否已满
	 * @return	true-已满
	 * 			false-未满
	 */
	boolean full();
	
	/**
	 * 展示栈内元素
	 */
	void show();
}
