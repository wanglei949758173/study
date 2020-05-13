/*      
 * 模块编号  
 * 功能描述 
 * 文件名 InfoColleage.java 
 * 作者 王磊 
 * 编写日期 2020年05月13日 
 */
package test.pattern.action.iterator.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import test.pattern.action.iterator.Colleage;
import test.pattern.action.iterator.Department;

public class InfoColleage extends Colleage {
	private List<Department> departments = new ArrayList<>();

	public InfoColleage() {
		departments.add(new Department("信管系", ""));
		departments.add(new Department("统计系", ""));
	}

	@Override
	public Iterator<Department> createIterator() {
		return new InfoColleageIterator(departments);
	}

}
