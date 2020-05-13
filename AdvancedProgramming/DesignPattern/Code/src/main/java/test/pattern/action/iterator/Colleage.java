/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Colleage.java 
 * 作者 王磊 
 * 编写日期 2020年05月13日 
 */
package test.pattern.action.iterator;

import java.util.Iterator;

public abstract class Colleage {
	public abstract Iterator<Department> createIterator();
}
