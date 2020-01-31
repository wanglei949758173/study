/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteClass.java  
 * 作者 王磊 
 * 编写日期 2018年9月5日    
 */
package pattern.templateMethod.template.impl;

import pattern.templateMethod.template.AbstractClass;

/**
 * 具体的模板
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteClass extends AbstractClass{

	@Override
	protected void f2() {
		System.out.println("ConcreteClass f2");
	}

}
