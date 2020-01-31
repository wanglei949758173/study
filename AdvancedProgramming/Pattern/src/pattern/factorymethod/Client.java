/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.factorymethod;

import pattern.factorymethod.factorymethod.FactoryMethod;
import pattern.factorymethod.factorymethod.impl.ProductAFactory;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		//创建工厂方法
		FactoryMethod factoryMethod = new ProductAFactory();
		
		factoryMethod.fun();
	}
}
