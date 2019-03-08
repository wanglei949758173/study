/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Proxy.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.proxy.proxy;

import pattern.proxy.subject.Subject;
/**
 * 代理类
 * 
 * @version 
 * @author 王磊
 */
public class Proxy implements Subject{

	private Subject subject;
	
	public Proxy(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void f1() {
		System.out.println("Proxy");
		subject.f1();
	}

	@Override
	public void f2() {
		System.out.println("Proxy");
		subject.f2();
	}

}
