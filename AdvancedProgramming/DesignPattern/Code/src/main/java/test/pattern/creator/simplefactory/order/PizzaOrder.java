/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaOrder.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.simplefactory.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import test.pattern.creator.simplefactory.factory.PizzaFactory;
import test.pattern.creator.simplefactory.pizza.Pizza;

public class PizzaOrder {
	private PizzaFactory pizzaFactory;

	public PizzaOrder(PizzaFactory pizzaFactory) {
		this.pizzaFactory = pizzaFactory;
	}
	
	public void working() {
		order();
	}

	/**
	 * 订购
	 */
	private void order() {
		do {
			// 获取订购类型
			String orderType = getType();
			Pizza pizza = this.pizzaFactory.createPizza(orderType);

			// 输出pizza
			if (pizza != null) { // 订购成功
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.err.println("订购披萨失败");
				break;
			}
		} while (true);
	}

	/**
	 * 获取用户输入的订购类型
	 * @return	订购类型
	 */
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 种类:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
