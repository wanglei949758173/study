/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.simplefactory;

import pattern.simplefactory.factory.Factory;
import pattern.simplefactory.product.Product;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		//获取B产品
		Product product = Factory.createProduct("B");
		
		product.f();
	}
}
