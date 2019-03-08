/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ProductAFactory.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.factorymethod.factorymethod.impl;

import pattern.factorymethod.Product.Product;
import pattern.factorymethod.Product.impl.ProductImplB;
import pattern.factorymethod.factorymethod.FactoryMethod;
/**
 * 产品B的工厂实现
 * 
 * @version 
 * @author 王磊
 */
public class ProductBFactory extends FactoryMethod{

	@Override
	protected Product getProduct() {
		return new ProductImplB();
	}

}
