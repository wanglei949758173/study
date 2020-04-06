/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Decorator.java 
 * 作者 王磊 
 * 编写日期 2020年04月06日 
 */
package test.pattern.structure.decorator.decorator;

import test.pattern.structure.decorator.Drink;

public class Decorator extends Drink{
	private Drink coffee;
	
	public Decorator(Drink coffee) {
		super();
		this.coffee = coffee;
	}

	@Override
	public float cost() {
		return super.getPrice() + this.coffee.cost();
	}
	
	@Override
	public String getDescription() {
		if (coffee instanceof Decorator) {
			return super.getDescription() + super.getPrice() + " && " + coffee.getDescription();
		} else {
			return super.getDescription() + super.getPrice() + " && " + coffee.getDescription() + coffee.getPrice();
		}
	}

}
