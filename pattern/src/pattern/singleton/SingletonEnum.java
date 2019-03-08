/**      
 * 模块编号  
 * 功能描述 
 * 文件名 SingletonEnum.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.singleton;

public enum SingletonEnum {
	INSTANCE;
	
	private Singleton instance = null;
	
	private SingletonEnum() {
		System.out.println("instance init.....");
		instance = new Singleton();
	}
	
	public Singleton getInstance() {
		return instance;
	}

	
	class Singleton {
		private Singleton() {
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main ....");
		Singleton singleton1 = SingletonEnum.INSTANCE.getInstance();
		Singleton singleton2 = SingletonEnum.INSTANCE.getInstance();
		
		System.out.println(singleton1 == singleton2);
	}
}



