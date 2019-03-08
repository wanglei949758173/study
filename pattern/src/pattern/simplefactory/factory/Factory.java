/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Factory.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.simplefactory.factory;
/**
 * 工厂类
 * 
 * @version 
 * @author 王磊
 */

import pattern.simplefactory.product.Product;
import pattern.simplefactory.product.impl.ProductA;
import pattern.simplefactory.product.impl.ProductB;

public class Factory {
	private Factory() {
	}

	/**
	 * 创建产品
	 * @return
	 */
	public static Product createProduct(String type) {
		if ("A".equals(type)) {
			return new ProductA();
		} else if ("B".equals(type)) {
			return new ProductB();
		} else {
			return null;
		}
	}
}
