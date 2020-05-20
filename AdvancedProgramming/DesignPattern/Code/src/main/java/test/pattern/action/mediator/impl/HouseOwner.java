/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HouseOwner.java 
 * 作者 王磊 
 * 编写日期 2020年05月20日 
 */
package test.pattern.action.mediator.impl;

import test.pattern.action.mediator.HouseOwnerCustomer;
import test.pattern.action.mediator.Mediator;
import test.pattern.action.mediator.TMessageType;

/**
 * 房东
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class HouseOwner extends HouseOwnerCustomer{

	public HouseOwner(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void sendMessage(TMessageType messageType) {
		System.out.println("询问妻子");
		this.getMediator().getMessage(messageType);
	}
}
