/*      
 * 模块编号  
 * 功能描述 
 * 文件名 BlackBeanSoyaMilk.java 
 * 作者 王磊 
 * 编写日期 2020年04月26日 
 */
package test.pattern.structure.templatemethod.impl;

import test.pattern.structure.templatemethod.SoyaMilk;

public class BlackBeanSoyaMilk extends SoyaMilk {

	@Override
	protected void select() {
		System.out.println("选择黑豆");
	}

	@Override
	protected boolean needsAddCondiments() {
		return false;
	}

}
