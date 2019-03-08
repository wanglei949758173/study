/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ProductA.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.simplefactory.product.impl;

import pattern.simplefactory.product.Product;

public class ProductA extends Product{

	@Override
	public void f() {
		System.out.println("ProductA.............");
	}

}
