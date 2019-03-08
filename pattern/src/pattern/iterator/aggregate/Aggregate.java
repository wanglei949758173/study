/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Aggregate.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.iterator.aggregate;

import pattern.iterator.iterator.Iterator;

/**
 * 抽象聚合对象
 * 
 * @version 
 * @author 王磊
 */
public abstract class Aggregate {
	
	public abstract Iterator createIterator();
}
