/*      
 * 模块编号  
 * 功能描述 
 * 文件名 College.java 
 * 作者 王磊 
 * 编写日期 2020年04月13日 
 */
package test.pattern.structure.composite.impl;

import java.util.ArrayList;
import java.util.List;

import test.pattern.structure.composite.OrganizationComponent;

public class College extends OrganizationComponent {

	private List<OrganizationComponent> departments = new ArrayList<OrganizationComponent>();

	public College(String name, String des) {
		super(name, des);
	}

	@Override
	public void add(OrganizationComponent organizationComponent) {
		departments.add(organizationComponent);
	}

	@Override
	public void remove(OrganizationComponent organizationComponent) {
		departments.remove(organizationComponent);
	}

	@Override
	public void print() {
		System.out.println("----------------" + getName() + "----------------");
		this.departments.forEach(department -> {
			department.print();
		});
	}

}
