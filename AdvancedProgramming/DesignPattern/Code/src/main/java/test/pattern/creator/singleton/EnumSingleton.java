/*      
 * 模块编号  
 * 功能描述 枚举方式的单例
 * 文件名 EnumSingleton.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.singleton;

public enum EnumSingleton {
	INSTANCE;
	
	public void method1() {
		System.out.println("method1");
	}
}
