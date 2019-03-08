/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteAggregate.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.iterator.aggregate.impl;

import pattern.iterator.aggregate.Aggregate;
import pattern.iterator.iterator.ConcreteIterator;
import pattern.iterator.iterator.Iterator;
/**
 * 聚合实现
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteAggregate extends Aggregate {
	private String[] ss = null;
	
	public ConcreteAggregate(String[] ss){
		this.ss = ss;
	}
	
	public int size(){
		return this.ss.length;
	}
	
	public Object get(int index){
		Object retObj = null;
		if(index < ss.length){
			retObj = ss[index];
		}
		return retObj;
	}

	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}

}
