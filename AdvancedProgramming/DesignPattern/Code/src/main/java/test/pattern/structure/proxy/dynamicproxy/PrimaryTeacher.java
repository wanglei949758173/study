/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PrimaryTeacher.java 
 * 作者 王磊 
 * 编写日期 2020年04月25日 
 */
package test.pattern.structure.proxy.dynamicproxy;

import test.pattern.structure.proxy.Teacher;

public class PrimaryTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("正式上课");
	}

}
