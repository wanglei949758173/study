/*      
 * 模块编号  
 * 功能描述 
 * 文件名 OrganizationComponent.java 
 * 作者 王磊 
 * 编写日期 2020年04月13日 
 */
package test.pattern.structure.composite;

public abstract class OrganizationComponent {
	private String name; // 名字
	private String des; // 说明

	protected void add(OrganizationComponent organizationComponent) {
		// 默认实现
		throw new UnsupportedOperationException();
	}

	protected void remove(OrganizationComponent organizationComponent) {
		// 默认实现
		throw new UnsupportedOperationException();
	}

	// 构造器
	public OrganizationComponent(String name, String des) {
		super();
		this.name = name;
		this.des = des;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	// 方法print, 做成抽象的, 子类都需要实现
	public abstract void print();

}
