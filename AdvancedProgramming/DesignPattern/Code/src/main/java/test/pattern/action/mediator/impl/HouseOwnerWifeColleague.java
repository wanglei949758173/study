/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HouseOwnerWifeColleague.java 
 * 作者 王磊 
 * 编写日期 2020年05月20日 
 */
package test.pattern.action.mediator.impl;

import test.pattern.action.mediator.HouseOwnerCustomer;
import test.pattern.action.mediator.Mediator;
import test.pattern.action.mediator.TMessageType;

/**
 * 房东妻子同事
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class HouseOwnerWifeColleague extends HouseOwnerCustomer {

	public HouseOwnerWifeColleague(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void sendMessage(TMessageType messageType) {
		System.out.println("告诉房东妻子价格");
		this.getMediator().getMessage(messageType);
	}

}
