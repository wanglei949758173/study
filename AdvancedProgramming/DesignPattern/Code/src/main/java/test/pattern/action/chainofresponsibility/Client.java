/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年06月09日 
 */
package test.pattern.action.chainofresponsibility;

import test.pattern.action.chainofresponsibility.impl.CollegeApprover;
import test.pattern.action.chainofresponsibility.impl.DepartmentApprover;
import test.pattern.action.chainofresponsibility.impl.SchoolMasterApprover;
import test.pattern.action.chainofresponsibility.impl.ViceSchoolMasterApprover;

public class Client {
	public static void main(String[] args) {
		// 创建一个请求
		PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);

		// 创建相关的审批人
		DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
		CollegeApprover collegeApprover = new CollegeApprover("李院长");
		ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校");
		SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("佟校长");

		// 需要将各个审批级别的下一个设置好 (处理人构成环形)
		departmentApprover.setApprover(collegeApprover);
		collegeApprover.setApprover(viceSchoolMasterApprover);
		viceSchoolMasterApprover.setApprover(schoolMasterApprover);
		schoolMasterApprover.setApprover(departmentApprover);

		departmentApprover.processRequest(purchaseRequest);
		viceSchoolMasterApprover.processRequest(purchaseRequest);
	}
}
