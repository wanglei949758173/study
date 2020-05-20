/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Mediator.java 
 * 作者 王磊 
 * 编写日期 2020年05月20日 
 */
package test.pattern.action.mediator;

public interface Mediator {
	/**
	 * 租房
	 */
	void rentingHouse();
	
	/**
	 * 获得房东客户发送的小
	 * @param messageType	消息类型
	 */
	void getMessage(TMessageType messageType);
}
