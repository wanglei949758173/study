/**      
 * 模块编号  
 * 功能描述 
 * 文件名 DoubleCheckSingleton.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.singleton;

public class DoubleCheckSingleton {
	private DoubleCheckSingleton() {
	}
	
	private static DoubleCheckSingleton instance;
	public static DoubleCheckSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}
}
