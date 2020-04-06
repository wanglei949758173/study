/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Milk.java 
 * 作者 王磊 
 * 编写日期 2020年04月06日 
 */
package test.pattern.structure.decorator.decorator;

import test.pattern.structure.decorator.Drink;

public class Milk extends Decorator{

	public Milk(Drink coffee) {
		super(coffee);
		setPrice(1.3f);
		setDescription(" 牛奶 ");
	}
}
