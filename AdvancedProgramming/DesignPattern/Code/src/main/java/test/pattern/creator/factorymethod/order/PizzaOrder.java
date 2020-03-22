/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PizzaOrder.java 
 * 作者 王磊 
 * 编写日期 2020年03月22日 
 */
package test.pattern.creator.factorymethod.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import test.pattern.creator.factorymethod.factory.PizzaFactory;

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
			// 获取订购类型和配送类型
			String pizzaType = getPizzaType();
			String deliveriesType = getDeliveriesType();
			
			// 交给工厂配送
			this.pizzaFactory.deliveries(pizzaType, deliveriesType);
		} while (true);
	}
	
	/**
	 * 获取用户输入的订购类型
	 * @return	订购类型
	 */
	private String getPizzaType() {
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
	
	/**
	 * 获取用户输入的配送类型
	 * @return	配送类型
	 */
	private String getDeliveriesType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input 配送类型:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
