/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Clinent.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.iterator;

import pattern.iterator.aggregate.Aggregate;
import pattern.iterator.aggregate.impl.ConcreteAggregate;
import pattern.iterator.iterator.Iterator;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		String[] ss = {"张三", "李四", "王麻子"};
		
		Aggregate aggregate = new ConcreteAggregate(ss);
		
		Iterator iterator = aggregate.createIterator();
		
		while (!iterator.isDone()) {
			iterator.next();
			System.out.println(iterator.currentItem());
		}
	}
}
