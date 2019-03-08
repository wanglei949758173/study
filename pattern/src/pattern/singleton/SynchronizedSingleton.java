/**      
 * 模块编号  
 * 功能描述 
 * 文件名 SynchronizedSingleton.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.singleton;
/**
 * 同步方法单例
 * 
 * @version 
 * @author 王磊
 */
public class SynchronizedSingleton {
	private SynchronizedSingleton() {
	}
	
	private static SynchronizedSingleton instance;
	
	public synchronized static SynchronizedSingleton getInstance() {
		if (instance == null) {
			instance = new SynchronizedSingleton();
		}
		return instance;
	}
}
