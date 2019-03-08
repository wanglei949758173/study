/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.abstractfactory;

import pattern.abstractfactory.abstractfactory.AbstractFactory;
import pattern.abstractfactory.abstractfactory.impl.Factory35;
import pattern.abstractfactory.product.ProductA;
import pattern.abstractfactory.product.ProductB;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		AbstractFactory factory = new Factory35();
		
		ProductA productA = factory.getProductA();
		productA.getNum();
		ProductB productB = factory.getProductB();
		productB.myNum();
	}
}
