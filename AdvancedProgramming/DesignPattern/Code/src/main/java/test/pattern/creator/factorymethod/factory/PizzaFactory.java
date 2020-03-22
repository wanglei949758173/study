/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaFactory.java 
 * 作者 王磊 
 * 编写日期 2020年03月22日 
 */
package test.pattern.creator.factorymethod.factory;

import test.pattern.creator.factorymethod.pizza.Pizza;

public abstract class PizzaFactory {
	// 抽象方法，由子类实现
	public abstract Pizza createPizza(String pizzaType);

	public void deliveries(String pizzaType, String deliveriesType) {
		// 创建pizza
		Pizza pizza = createPizza(pizzaType);
		
		if (pizza != null) { // 订购成功
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
			// 打包完成，进行配送
			System.out.println(deliveriesType);
		} else {
			System.err.println("订购披萨失败");
		}
	}
}
