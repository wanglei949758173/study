/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaFactoryImpl.java 
 * 作者 王磊 
 * 编写日期 2020年03月22日 
 */
package test.pattern.creator.abstractfactory.factory;

import test.pattern.creator.abstractfactory.box.CheesePizzaBox;
import test.pattern.creator.abstractfactory.box.PizzaBox;
import test.pattern.creator.abstractfactory.pizza.CheesePizza;
import test.pattern.creator.abstractfactory.pizza.Pizza;

public class CheesePizzaFactory extends PizzaFactory{

	@Override
	public Pizza createPizza() {
		return new CheesePizza();
	}

	@Override
	public PizzaBox createPizzaBox() {
		return new CheesePizzaBox();
	}

}
