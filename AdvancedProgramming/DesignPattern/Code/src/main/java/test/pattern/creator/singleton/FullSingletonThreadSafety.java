/*     
 * 模块编号  
 * 功能描述 线程安全的饱汉式单例
 * 文件名 FullSingletonThreadSafety.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.singleton;

public class FullSingletonThreadSafety {
	private FullSingletonThreadSafety() {
	}

	private static FullSingletonThreadSafety instance;

	// 线程安全，性能不好
	public static synchronized FullSingletonThreadSafety getInstance() {
		if (instance == null) {
			instance = new FullSingletonThreadSafety();
		}
		return instance;
	}
}
