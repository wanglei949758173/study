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
 * A35
 * 
 * @version 
 * @author 王磊
 */
public class A35 extends ProductA{

	public A35() {
		this.num = 35;
	}

	@Override
	public void getNum() {
		System.out.println("我需要一个编号为:" + this.num + "的B产品");
	}

}
