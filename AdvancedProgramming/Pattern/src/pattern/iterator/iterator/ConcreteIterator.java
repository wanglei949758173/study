/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteIterator.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.iterator.iterator;
/**
 * 迭代器实现
 * 
 * @version 
 * @author 王磊
 */

import pattern.iterator.aggregate.impl.ConcreteAggregate;

public class ConcreteIterator implements Iterator {
	
	private ConcreteAggregate aggregate;
	
	public ConcreteIterator(ConcreteAggregate concreteAggregate) {
		this.aggregate = concreteAggregate;
	}

	private int index = -1;

	@Override
	public void first() {
		index = 0;
	}

	@Override
	public void next() {
		if(index < this.aggregate.size()){
			index = index + 1;
		}
	}

	@Override
	public boolean isDone() {
		if(index == this.aggregate.size() - 1){
			return true;
		}
		return false;
	}

	@Override
	public Object currentItem() {
		return this.aggregate.get(index);
	}

}
