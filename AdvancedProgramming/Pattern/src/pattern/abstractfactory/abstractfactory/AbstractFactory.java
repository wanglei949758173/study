/**      
 * 模块编号  
 * 功能描述 
 * 文件名 AbstractFactory.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.abstractfactory.abstractfactory;

import pattern.abstractfactory.product.ProductA;
import pattern.abstractfactory.product.ProductB;

/**
 * 抽象工厂
 * 
 * @version 
 * @author 王磊
 */
public abstract class AbstractFactory {
	public abstract ProductA getProductA();
	
	public abstract ProductB getProductB();
}
