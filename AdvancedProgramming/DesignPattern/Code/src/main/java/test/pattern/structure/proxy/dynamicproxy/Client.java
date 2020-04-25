/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年04月25日 
 */
package test.pattern.structure.proxy.dynamicproxy;

import test.pattern.structure.proxy.Teacher;

public class Client {
	public static void main(String[] args) {
		Teacher teacher = new PrimaryTeacher();
		ProxyFacotry proxyFacotry = new ProxyFacotry(teacher);
		Teacher counselor = (Teacher) proxyFacotry.getProxyInstance();
		
		counselor.teach();
	}
}
