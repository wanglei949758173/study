/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Factory35.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.abstractfactory.abstractfactory.impl;

import pattern.abstractfactory.abstractfactory.AbstractFactory;
import pattern.abstractfactory.product.ProductA;
import pattern.abstractfactory.product.ProductB;
import pattern.abstractfactory.product.impl.A97;
import pattern.abstractfactory.product.impl.B97;
/**
 * 97工厂
 * 
 * @version 
 * @author 王磊
 */
public class Factory97 extends AbstractFactory{

	@Override
	public ProductA getProductA() {
		return new A97();
	}

	@Override
	public ProductB getProductB() {
		return new B97();
	}

}
