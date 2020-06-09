/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PurchaseRequest.java 
 * 作者 王磊 
 * 编写日期 2020年06月09日 
 */
package test.pattern.action.chainofresponsibility;

public class PurchaseRequest {
	// 请求类型
	private int type = 0;
	// 请求金额
	private float price = 0.0f;
	// id
	private int id = 0;

	// 构造器
	public PurchaseRequest(int type, float price, int id) {
		this.type = type;
		this.price = price;
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public float getPrice() {
		return price;
	}

	public int getId() {
		return id;
	}

}
