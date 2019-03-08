/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteCollegeA.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.mediator.college.impl;

import pattern.mediator.college.College;
import pattern.mediator.mediator.Mediator;

/**
 * 同事B
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteCollegeB extends College{

	
	public ConcreteCollegeB(Mediator mediator) {
		super(mediator);
	}

	public void someOperation() {
		System.out.println("ConcreteCollegeB..");
		getMediator().change(this);
	}
}
