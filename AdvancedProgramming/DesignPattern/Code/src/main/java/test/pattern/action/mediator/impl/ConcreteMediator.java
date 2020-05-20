/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteMediator.java 
 * 作者 王磊 
 * 编写日期 2020年05月20日 
 */
package test.pattern.action.mediator.impl;

import java.util.HashMap;
import java.util.Map;

import test.pattern.action.mediator.HouseOwnerCustomer;
import test.pattern.action.mediator.Mediator;
import test.pattern.action.mediator.TMessageType;

public class ConcreteMediator implements Mediator {
	private Map<String, HouseOwnerCustomer> houseOwnerCustomers =
			new HashMap<String, HouseOwnerCustomer>();

	public ConcreteMediator() {
		// 注册所有房东客户
		houseOwnerCustomers.put("HouseOwner", new HouseOwner(this));
		houseOwnerCustomers.put("HouseOwnerWife", new HouseOwnerWife(this));
		houseOwnerCustomers.put("HouseOwnerWifeColleague", new HouseOwnerWifeColleague(this));
	}

	@Override
	public void rentingHouse() {
		// 通知房东
		houseOwnerCustomers.get("HouseOwner").sendMessage(TMessageType.COMMUNICATION_WITH_WIFE);
		System.out.println("中介获取到价格，与租户沟通	");
	}

	@Override
	public void getMessage(TMessageType messageType) {
		if (TMessageType.COMMUNICATION_WITH_WIFE.equals(messageType)) {
			houseOwnerCustomers.get("HouseOwnerWife").sendMessage(TMessageType.ASK_COLLEGUE);
		} else if (TMessageType.ASK_COLLEGUE.equals(messageType)) {
			houseOwnerCustomers.get("HouseOwnerWifeColleague").sendMessage(TMessageType.TELL_THE_PRICE);
		} else if (TMessageType.TELL_THE_PRICE.equals(messageType)) {
			System.out.println("房东妻子获取到价格，告诉中介价格");
		} else {
			System.out.println("错误的消息类型");
		}
	}

}
