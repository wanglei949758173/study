/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Department.java 
 * 作者 王磊 
 * 编写日期 2020年04月13日 
 */
package test.pattern.structure.composite.impl;

import test.pattern.structure.composite.OrganizationComponent;

public class Department extends OrganizationComponent{

	public Department(String name, String des) {
		super(name, des);
	}

	@Override
	public void print() {
		System.out.println(getName());
	}

}
