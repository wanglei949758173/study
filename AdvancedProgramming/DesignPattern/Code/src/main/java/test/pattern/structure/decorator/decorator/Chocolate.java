/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Chocolate.java 
 * 作者 王磊 
 * 编写日期 2020年04月06日 
 */
package test.pattern.structure.decorator.decorator;

import test.pattern.structure.decorator.Drink;

public class Chocolate extends Decorator {

	public Chocolate(Drink coffee) {
		super(coffee);
		setPrice(0.6f);
		setDescription(" 巧克力 ");
	}

}
