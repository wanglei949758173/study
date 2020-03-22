/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaFactory.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.simplefactory.factory;

import test.pattern.creator.simplefactory.pizza.CheesePizza;
import test.pattern.creator.simplefactory.pizza.GreekPizza;
import test.pattern.creator.simplefactory.pizza.PepperPizza;
import test.pattern.creator.simplefactory.pizza.Pizza;

public class PizzaFactory {
	/**
	 * 根据Pizza类型创建pizza
	 * @param pizzaType	pizza类型
	 * @return			pizza
	 */
	public Pizza createPizza(String pizzaType) {
		Pizza pizza = null;
		if (pizzaType.equals("greek")) {
			pizza = new GreekPizza();
		} else if (pizzaType.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (pizzaType.equals("pepper")) {
			pizza = new PepperPizza();
		}
		return pizza;
	}
}
