/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HouseOwnerCustomer.java 
 * 作者 王磊 
 * 编写日期 2020年05月20日 
 */
package test.pattern.action.mediator;

/**
 * 房东客户
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public abstract class HouseOwnerCustomer {
	/**
	 * 中介
	 */
	private Mediator mediator;

	protected Mediator getMediator() {
		return mediator;
	}

	public HouseOwnerCustomer(Mediator mediator) {
		super();
		this.mediator = mediator;
	}

	public abstract void sendMessage(TMessageType messageType);
}
