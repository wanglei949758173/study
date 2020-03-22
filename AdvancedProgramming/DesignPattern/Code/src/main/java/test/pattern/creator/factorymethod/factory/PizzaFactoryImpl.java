/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaFactoryImpl.java 
 * 作者 王磊 
 * 编写日期 2020年03月22日 
 */
package test.pattern.creator.factorymethod.factory;

import test.pattern.creator.factorymethod.pizza.CheesePizza;
import test.pattern.creator.factorymethod.pizza.GreekPizza;
import test.pattern.creator.factorymethod.pizza.PepperPizza;
import test.pattern.creator.factorymethod.pizza.Pizza;

public class PizzaFactoryImpl extends PizzaFactory{

	@Override
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
