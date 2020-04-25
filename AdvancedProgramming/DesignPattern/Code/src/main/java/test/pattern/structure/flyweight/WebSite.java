/*      
 * 模块编号  
 * 功能描述 
 * 文件名 WebSite.java 
 * 作者 王磊 
 * 编写日期 2020年04月22日 
 */
package test.pattern.structure.flyweight;

public abstract class WebSite {
	/**
	 * 网站类型(erp/crm)
	 */
	private String type;

	public String getType() {
		return type;
	}

	public WebSite(String type) {
		this.type = type;
	}

	public abstract void use();

	public abstract void setUI(String ui);
}
