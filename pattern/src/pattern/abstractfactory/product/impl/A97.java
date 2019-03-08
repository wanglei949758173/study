/**      
 * 模块编号  
 * 功能描述 
 * 文件名 A35.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.abstractfactory.product.impl;

import pattern.abstractfactory.product.ProductA;
/**
 * A97
 * 
 * @version 
 * @author 王磊
 */
public class A97 extends ProductA{

	public A97() {
		this.num = 97;
	}

	@Override
	public void getNum() {
		System.out.println("我需要一个编号为:" + this.num + "的B产品");
	}

}
