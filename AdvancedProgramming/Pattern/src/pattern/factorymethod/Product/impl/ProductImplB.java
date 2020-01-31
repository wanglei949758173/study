/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ProductImpl.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.factorymethod.Product.impl;

import pattern.factorymethod.Product.Product;
/**
 * 产品实现B
 * 
 * @version 
 * @author 王磊
 */
public class ProductImplB extends Product{

	@Override
	public void fun() {
		System.out.println("ProductImplB");
	}

}
