/*      
 * 模块编号  
 * 功能描述 
 * 文件名 University.java 
 * 作者 王磊 
 * 编写日期 2020年04月13日 
 */
package test.pattern.structure.composite.impl;

import java.util.ArrayList;
import java.util.List;

import test.pattern.structure.composite.OrganizationComponent;

public class University extends OrganizationComponent {
	private List<OrganizationComponent> colleges = new ArrayList<OrganizationComponent>();

	public University(String name, String des) {
		super(name, des);
	}

	@Override
	public void add(OrganizationComponent organizationComponent) {
		colleges.add(organizationComponent);
	}

	@Override
	protected void remove(OrganizationComponent organizationComponent) {
		colleges.remove(organizationComponent);
	}

	@Override
	public void print() {
		System.out.println("----------------" + getName() + "----------------");
		this.colleges.forEach(college -> {
			college.print();
		});
	}

}
