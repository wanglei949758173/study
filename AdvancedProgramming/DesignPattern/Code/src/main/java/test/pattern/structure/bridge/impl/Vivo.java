/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Vivo.java 
 * 作者 王磊 
 * 编写日期 2020年03月31日 
 */
package test.pattern.structure.bridge.impl;

import test.pattern.structure.bridge.PhoneFunction;

public class Vivo implements PhoneFunction {
	@Override
	public void open() {
		System.out.println(" Vivo手机开机 ");
	}

	@Override
	public void close() {
		System.out.println(" Vivo手机关机 ");
	}

	@Override
	public void call() {
		System.out.println(" Vivo手机打电话 ");
	}
}
