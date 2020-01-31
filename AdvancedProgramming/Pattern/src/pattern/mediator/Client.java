/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.mediator;

import pattern.mediator.college.impl.ConcreteCollegeA;
import pattern.mediator.college.impl.ConcreteCollegeB;
import pattern.mediator.mediator.impl.ConcreteMediator;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		ConcreteCollegeA concreteCollegeA = new ConcreteCollegeA(mediator);
		ConcreteCollegeB concreteCollegeB = new ConcreteCollegeB(mediator);
		
		mediator.setConcreteCollegeA(concreteCollegeA);
		mediator.setConcreteCollegeB(concreteCollegeB);
		
		concreteCollegeA.someOperation();
	}
}
