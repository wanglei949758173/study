/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年04月25日 
 */
package test.pattern.structure.proxy.cglib;

public class Client {
	public static void main(String[] args) {
		PrimaryTeacher primaryTeacher = new PrimaryTeacher();
		ProxyFactory proxyFactory = new ProxyFactory(primaryTeacher);
		PrimaryTeacher counselor = (PrimaryTeacher) proxyFactory.getProxyInstance();
		
		counselor.teach();
	}
}
