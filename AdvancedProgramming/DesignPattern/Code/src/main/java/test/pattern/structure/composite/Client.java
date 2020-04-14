/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年04月13日 
 */
package test.pattern.structure.composite;

import test.pattern.structure.composite.impl.College;
import test.pattern.structure.composite.impl.Department;
import test.pattern.structure.composite.impl.University;

public class Client {
	public static void main(String[] args) {
		University tinghua = new University("清华大学", "国际知名大学");
		
		// 计算机学院
		College computerCollege = new College("计算机学院", "高薪就业");
		// 系
		Department csDepartment = new Department("计算机科学与技术系", "");
		Department npDepartment = new Department("网络工程", "");
		computerCollege.add(csDepartment);
		computerCollege.add(npDepartment);
		
		tinghua.add(computerCollege);
		
		tinghua.print();
	}
}
