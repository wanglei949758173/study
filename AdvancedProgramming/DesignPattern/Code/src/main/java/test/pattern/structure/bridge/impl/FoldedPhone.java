/*      
 * 模块编号  
 * 功能描述 
 * 文件名 FoldedPhone.java 
 * 作者 王磊 
 * 编写日期 2020年03月31日 
 */
package test.pattern.structure.bridge.impl;

import test.pattern.structure.bridge.Phone;
import test.pattern.structure.bridge.PhoneFunction;

public class FoldedPhone extends Phone {

	// 构造器
	public FoldedPhone(PhoneFunction phoneFunction) {
		super(phoneFunction);
	}

	public void open() {
		super.open();
		System.out.println(" 直立样式手机 ");
	}

	public void close() {
		super.close();
		System.out.println(" 直立样式手机 ");
	}

	public void call() {
		super.call();
		System.out.println(" 直立样式手机 ");
	}
}
