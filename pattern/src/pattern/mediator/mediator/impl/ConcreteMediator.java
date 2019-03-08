/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteMediator.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.mediator.mediator.impl;

import pattern.mediator.college.College;
import pattern.mediator.college.impl.ConcreteCollegeA;
import pattern.mediator.college.impl.ConcreteCollegeB;
import pattern.mediator.mediator.Mediator;
/**
 * 具体中介者
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteMediator implements Mediator{
	@SuppressWarnings("unused")
	private ConcreteCollegeA concreteCollegeA;
	private ConcreteCollegeB concreteCollegeB;

	@Override
	public void change(College college) {
		if (college instanceof ConcreteCollegeA) {
			concreteCollegeB.someOperation();
		} else if (college instanceof ConcreteCollegeB) {
			System.out.println("nothing to do");
		}
	}

	public void setConcreteCollegeA(ConcreteCollegeA concreteCollegeA) {
		this.concreteCollegeA = concreteCollegeA;
	}

	public void setConcreteCollegeB(ConcreteCollegeB concreteCollegeB) {
		this.concreteCollegeB = concreteCollegeB;
	}
}
