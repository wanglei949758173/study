/**      
 * 模块编号  
 * 功能描述 
 * 文件名 FactoryMethod.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.factorymethod.factorymethod;

import pattern.factorymethod.Product.Product;
/**
 * 工厂方法
 * 
 * @version 
 * @author 王磊
 */
public abstract class FactoryMethod {
	protected abstract Product getProduct();
	
	
	public void fun() {
		//获取产品
		Product product = getProduct();
		
		//调用产品的方法
		product.fun();
	}
}
