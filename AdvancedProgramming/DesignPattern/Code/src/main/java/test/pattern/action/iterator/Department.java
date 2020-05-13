/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Department.java 
 * 作者 王磊 
 * 编写日期 2020年05月13日 
 */
package test.pattern.action.iterator;

public class Department {
	private String name;
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Department(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", desc=" + desc + "]";
	}
}
