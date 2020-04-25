/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年04月24日 
 */
package test.pattern.structure.proxy.staticproxy;

import test.pattern.structure.proxy.Teacher;

public class Client {
	public static void main(String[] args) {
		Teacher primaryTeacher = new PrimaryTeacher();
		Counselor counselor = new Counselor(primaryTeacher);
		
		counselor.teach();
	}
}
