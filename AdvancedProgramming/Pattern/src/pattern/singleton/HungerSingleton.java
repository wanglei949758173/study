/**      
 * 模块编号  
 * 功能描述 
 * 文件名 HungerSingle.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.singleton;
/**
 * 饿汉单例
 * 
 * @version 
 * @author 王磊
 */
public class HungerSingleton {
	private HungerSingleton() {
	}
	
	private static HungerSingleton instance = new HungerSingleton();
	
	public static HungerSingleton getInstance() {
		return instance;
	}
}
