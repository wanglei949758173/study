/*      
 * 模块编号  
 * 功能描述 
 * 文件名 RedBeanSoyaMilk.java 
 * 作者 王磊 
 * 编写日期 2020年04月26日 
 */
package test.pattern.action.templatemethod.impl;

import test.pattern.action.templatemethod.SoyaMilk;

public class RedBeanSoyaMilk extends SoyaMilk{

	@Override
	protected void select() {
		System.out.println("选择红豆");
	}

	@Override
	protected boolean needsAddCondiments() {
		return true;
	}
	
	@Override
	protected void addCondiments() {
		super.addCondiments();
		System.out.println("添加黑米");
	}

}
