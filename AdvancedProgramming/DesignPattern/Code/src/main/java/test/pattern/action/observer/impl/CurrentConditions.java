/*      
 * 模块编号  
 * 功能描述 
 * 文件名 CurrentConditions.java 
 * 作者 王磊 
 * 编写日期 2020年05月16日 
 */
package test.pattern.action.observer.impl;

import test.pattern.action.observer.Observer;

public class CurrentConditions implements Observer{

	@Override
	public void update(float temperature, float pressure, float humidity) {
		display(temperature, pressure, humidity);
	}

	public void display(float temperature, float pressure, float humidity) {
		System.out.println("当前温度=" + temperature);
		System.out.println("当前气压=" + pressure);
		System.out.println("当前湿度=" + humidity);
	}
}
