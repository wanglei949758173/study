/*      
 * 模块编号  
 * 功能描述 
 * 文件名 CollegeApprover.java 
 * 作者 王磊 
 * 编写日期 2020年06月09日 
 */
package test.pattern.action.chainofresponsibility.impl;

import test.pattern.action.chainofresponsibility.Approver;
import test.pattern.action.chainofresponsibility.PurchaseRequest;

public class CollegeApprover extends Approver {

	public CollegeApprover(String name) {
		super(name);
	}
	
	@Override
	public void processRequest(PurchaseRequest purchaseRequest) {
		if(purchaseRequest.getPrice() < 5000 && purchaseRequest.getPrice() <= 10000) {
			System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
		}else {
			upApprover.processRequest(purchaseRequest);
		}
	}
}
