/*      
 * 模块编号  
 * 功能描述 静态内部类方式的单例
 * 文件名 StaticInnerClassSingleton.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.singleton;

public class StaticInnerClassSingleton {
	private StaticInnerClassSingleton() {
	}
	
	private static class InnerClass {
		private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
	}
	
	public static StaticInnerClassSingleton getInstance() {
		return InnerClass.INSTANCE;
	}
}
