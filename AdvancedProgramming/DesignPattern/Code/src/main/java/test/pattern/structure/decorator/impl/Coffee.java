/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Coffee.java 
 * 作者 王磊 
 * 编写日期 2020年04月06日 
 */
package test.pattern.structure.decorator.impl;

import test.pattern.structure.decorator.Drink;

public class Coffee extends Drink{

	@Override
	public float cost() {
		return super.getPrice();
	}

}
