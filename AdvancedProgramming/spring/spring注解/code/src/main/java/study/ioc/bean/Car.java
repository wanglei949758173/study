/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Car.java 
 * 作者 王磊 
 * 编写日期 2020年06月22日 
 */
package study.ioc.bean;

public class Car {
	// construct后被调用
	@SuppressWarnings("unused")
	private void init() {
		System.out.println("car init");
	}

	// 被最早调用
	public Car() {
		System.out.println("car construct");
	}

	// 单例对象容器关闭时调用
	// 多实例对象不调用
	@SuppressWarnings("unused")
	private void destroy() {
		System.out.println("car destroy");
	}
}
