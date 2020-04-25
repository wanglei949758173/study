/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PrimaryTeacher.java 
 * 作者 王磊 
 * 编写日期 2020年04月24日 
 */
package test.pattern.structure.proxy.staticproxy;

import test.pattern.structure.proxy.Teacher;

/**
 * 主讲老师(目标，要被代理的类)
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class PrimaryTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("正式上课");
	}

}
