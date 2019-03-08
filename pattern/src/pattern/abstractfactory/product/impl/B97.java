/**      
 * 模块编号  
 * 功能描述 
 * 文件名 B35.java  
 * 作者 王磊 
 * 编写日期 2018年8月24日    
 */
package pattern.abstractfactory.product.impl;

import pattern.abstractfactory.product.ProductB;
/**
 * B97
 * 
 * @version 
 * @author 王磊
 */
public class B97 extends ProductB{

	@Override
	public void myNum() {
		System.out.println("我是编号：" + this.num + "的B产品");
	}

	public B97() {
		this.num = 97;
	}

}
