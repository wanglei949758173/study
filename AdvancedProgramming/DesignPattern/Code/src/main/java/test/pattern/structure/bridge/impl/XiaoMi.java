/*      
 * 模块编号  
 * 功能描述 
 * 文件名 XiaoMi.java 
 * 作者 王磊 
 * 编写日期 2020年03月31日 
 */
package test.pattern.structure.bridge.impl;

import test.pattern.structure.bridge.PhoneFunction;

public class XiaoMi implements PhoneFunction {
	@Override
	public void open() {
		System.out.println(" 小米手机开机 ");
	}

	@Override
	public void close() {
		System.out.println(" 小米手机关机 ");
	}

	@Override
	public void call() {
		System.out.println(" 小米手机打电话 ");
	}
}
