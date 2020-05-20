/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Tenant.java 
 * 作者 王磊 
 * 编写日期 2020年05月20日 
 */
package test.pattern.action.mediator;

import test.pattern.action.mediator.impl.ConcreteMediator;

/**
 * 租客
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Tenant {
	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();
		mediator.rentingHouse();
	}
}
