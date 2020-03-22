/*      
 * 模块编号  
 * 功能描述 饱汉式单例
 * 文件名 FullSingleton.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.singleton;

public class FullSingleton {
	private FullSingleton() {
	}

	private static FullSingleton instance;

	// 线程不安全
	public static FullSingleton getInstance() {
		if (instance == null) {
			instance = new FullSingleton();
		}
		return instance;
	}
}
