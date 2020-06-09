/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Approver.java 
 * 作者 王磊 
 * 编写日期 2020年06月09日 
 */
package test.pattern.action.chainofresponsibility;

public abstract class Approver {
	/**
	 * 上级审批人
	 */
	protected Approver upApprover;
	/**
	 * 名字
	 */
	protected String name;

	public Approver(String name) {
		this.name = name;
	}

	public void setApprover(Approver upApprover) {
		this.upApprover = upApprover;
	}

	// 处理审批请求的方法，得到一个请求, 处理是子类完成，因此该方法做成抽象
	public abstract void processRequest(PurchaseRequest purchaseRequest);
}
