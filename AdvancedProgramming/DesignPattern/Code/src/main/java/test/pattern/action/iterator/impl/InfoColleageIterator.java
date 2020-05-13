/*      
 * 模块编号  
 * 功能描述 
 * 文件名 InfoColleageIterator.java 
 * 作者 王磊 
 * 编写日期 2020年05月13日 
 */
package test.pattern.action.iterator.impl;

import java.util.Iterator;
import java.util.List;

import test.pattern.action.iterator.Department;

public class InfoColleageIterator implements Iterator<Department> {
	private List<Department> departments;

	public InfoColleageIterator(List<Department> departments) {
		super();
		this.departments = departments;
	}

	private int index = 0;

	@Override
	public boolean hasNext() {
		return index < departments.size();
	}

	@Override
	public Department next() {
		Department department = departments.get(index);
		index += 1;
		return department;
	}

}
