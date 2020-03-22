/*      
 * 模块编号  
 * 功能描述 饱汉式双重检查的单例
 * 文件名 FullSingletonDoubleCheck.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.singleton;

public class FullSingletonDoubleCheck {
	private FullSingletonDoubleCheck() {
	}

	private static volatile FullSingletonDoubleCheck instance;

	// 线程安全，性能好
	public static FullSingletonDoubleCheck getInstance() {
		if (instance == null) {
			synchronized (FullSingletonDoubleCheck.class) {
				if (instance == null) {
					instance = new FullSingletonDoubleCheck();
				}
			}
		}
		return instance;
	}
}
