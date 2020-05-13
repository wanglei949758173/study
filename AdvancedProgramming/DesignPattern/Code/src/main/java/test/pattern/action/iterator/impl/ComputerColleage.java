/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ComputerColleage.java 
 * 作者 王磊 
 * 编写日期 2020年05月13日 
 */
package test.pattern.action.iterator.impl;

import java.util.Iterator;

import test.pattern.action.iterator.Colleage;
import test.pattern.action.iterator.Department;

public class ComputerColleage extends Colleage {
	private Department[] departments = { new Department("计算机系", ""), new Department("网络工程系", "") };

	@Override
	public Iterator<Department> createIterator() {
		return new ComputerColleageIterator(departments);
	}

}
