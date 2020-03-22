/*      
 * 模块编号  
 * 功能描述 饿汉式单利
 * 文件名 HungrySingleton.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.singleton;

public class HungrySingleton {
	private HungrySingleton() {
	}
	
	/**
	 * 实例
	 */
	private static final HungrySingleton INSTANCE = new HungrySingleton();
	
	/**
	 * 获取实例
	 * @return	实例
	 */
	public static HungrySingleton getInstance() {
		return INSTANCE;
	}
}
