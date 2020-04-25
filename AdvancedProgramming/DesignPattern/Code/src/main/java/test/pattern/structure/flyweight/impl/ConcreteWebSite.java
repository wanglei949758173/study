/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteWebSite.java 
 * 作者 王磊 
 * 编写日期 2020年04月22日 
 */
package test.pattern.structure.flyweight.impl;

import test.pattern.structure.flyweight.WebSite;

public class ConcreteWebSite extends WebSite {

	private String ui;

	public ConcreteWebSite(String type) {
		super(type);
	}

	@Override
	public void use() {
		System.out.println(String.format("网站类型：[%s]，网站UI：[%s]", this.getType(), ui));
	}

	@Override
	public void setUI(String ui) {
		this.ui = ui;
	}

}
