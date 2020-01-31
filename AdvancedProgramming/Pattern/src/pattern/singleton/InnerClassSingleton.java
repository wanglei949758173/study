/**      
 * 模块编号  
 * 功能描述 
 * 文件名 InnerClassSingleton.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.singleton;
/**
 * 静态内部类方式的单例
 * 
 * @version 
 * @author 王磊
 */
public class InnerClassSingleton {
	private InnerClassSingleton() {
	}
	
	public static InnerClassSingleton getInstance() {
		return InnerClass.instance;
	}
	
	private static class InnerClass{
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}
}
