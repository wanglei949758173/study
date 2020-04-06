/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestBridge.java 
 * 作者 王磊 
 * 编写日期 2020年03月31日 
 */
package test.pattern.structure.bridge;

import test.pattern.structure.bridge.impl.FoldedPhone;
import test.pattern.structure.bridge.impl.UpRightPhone;
import test.pattern.structure.bridge.impl.XiaoMi;

public class TestBridge {
	public static void main(String[] args) {
		// 折叠小米手机
		Phone foldedXiaomiPhone = new FoldedPhone(new XiaoMi());
		foldedXiaomiPhone.open();
		foldedXiaomiPhone.call();
		foldedXiaomiPhone.close();
		System.out.println();
		
		// 直立式小米手机
		Phone upRightXiaomiPhone = new UpRightPhone(new XiaoMi());
		upRightXiaomiPhone.open();
		upRightXiaomiPhone.call();
		upRightXiaomiPhone.close();
	}
}
