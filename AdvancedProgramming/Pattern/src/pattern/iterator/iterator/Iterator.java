/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Iterator.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.iterator.iterator;
/**
 * 抽象迭代器
 * 
 * @version 
 * @author 王磊
 */
public interface Iterator {
	void first();
	
	void next();
	
	boolean isDone();
	
	Object currentItem();
}
