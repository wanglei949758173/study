/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ComputerColleageIterator.java 
 * 作者 王磊 
 * 编写日期 2020年05月13日 
 */
package test.pattern.action.iterator.impl;

import java.util.Iterator;

import test.pattern.action.iterator.Department;

public class ComputerColleageIterator implements Iterator<Department> {
	private Department[] departments;

	public ComputerColleageIterator(Department[] departments) {
		this.departments = departments;
	}

	private int index = 0;

	@Override
	public boolean hasNext() {
		return index < departments.length;
	}

	@Override
	public Department next() {
		Department department = departments[index];
		index += 1;
		return department;
	}

}
