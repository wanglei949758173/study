/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Counselor.java 
 * 作者 王磊 
 * 编写日期 2020年04月24日 
 */
package test.pattern.structure.proxy.staticproxy;

import test.pattern.structure.proxy.Teacher;

/**
 * 辅导老师(代理者)
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Counselor implements Teacher {
	/**
	 * 主讲老师
	 */
	private Teacher primaryTeacher;

	public Counselor(Teacher primaryTeacher) {
		super();
		this.primaryTeacher = primaryTeacher;
	}

	@Override
	public void teach() {
		System.out.println("开始讲课前预习题目");
		System.out.println("讲解课前预习题目完毕");

		// 主讲老师正式上课
		primaryTeacher.teach();
	}
}
