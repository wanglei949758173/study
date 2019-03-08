/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.proxy;

import pattern.proxy.proxy.Proxy;
import pattern.proxy.subject.Subject;
import pattern.proxy.subject.impl.RealSubject;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		Subject subject = new RealSubject();
		
		Proxy proxy = new Proxy(subject);
		
		proxy.f1();
		proxy.f2();
	}
}
