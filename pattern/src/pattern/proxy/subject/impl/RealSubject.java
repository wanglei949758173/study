/**      
 * 模块编号  
 * 功能描述 
 * 文件名 RealSubject.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.proxy.subject.impl;

import pattern.proxy.subject.Subject;

public class RealSubject implements Subject{

	@Override
	public void f1() {
		System.out.println("RealSubject f1");
	}

	@Override
	public void f2() {
		System.out.println("RealSubject f2");
	}

}
