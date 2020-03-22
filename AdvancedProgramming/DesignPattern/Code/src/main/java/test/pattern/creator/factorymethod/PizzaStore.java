/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaStore.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.factorymethod;

import test.pattern.creator.factorymethod.factory.PizzaFactoryImpl;
import test.pattern.creator.factorymethod.order.PizzaOrder;

public class PizzaStore {
	public static void main(String[] args) {
		PizzaOrder pizzaOrder = new PizzaOrder(new PizzaFactoryImpl());
		pizzaOrder.working();
	}
}
