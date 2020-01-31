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
import pattern.abstractfactory.product.impl.A35;
import pattern.abstractfactory.product.impl.B35;
/**
 * 35工厂
 * 
 * @version 
 * @author 王磊
 */
public class Factory35 extends AbstractFactory{

	@Override
	public ProductA getProductA() {
		return new A35();
	}

	@Override
	public ProductB getProductB() {
		return new B35();
	}

}
