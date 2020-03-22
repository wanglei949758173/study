/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaFactory.java 
 * 作者 王磊 
 * 编写日期 2020年03月22日 
 */
package test.pattern.creator.abstractfactory.factory;

import test.pattern.creator.abstractfactory.box.PizzaBox;
import test.pattern.creator.abstractfactory.pizza.Pizza;

public abstract class PizzaFactory {
	public abstract Pizza createPizza();
	
	public abstract PizzaBox createPizzaBox();
	
}
