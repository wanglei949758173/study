/*      
 * 模块编号  
 * 功能描述 
 * 文件名 WeatherData.java 
 * 作者 王磊 
 * 编写日期 2020年05月16日 
 */
package test.pattern.action.observer.impl;

import java.util.ArrayList;
import java.util.List;

import test.pattern.action.observer.Observer;
import test.pattern.action.observer.Subject;

public class WeatherData implements Subject {
	/**
	 * 所有观察者
	 */
	private List<Observer> observers = new ArrayList<>();

	/**
	 * 湿度
	 */
	private float humidity;

	/**
	 * 气压
	 */
	private float pressure;

	/**
	 * 温度
	 */
	private float temperature;

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(observer -> {
			observer.update(temperature, pressure, humidity);
		});
	}

	public void setData(float temperature, float pressure, float humidity) {
		this.pressure = pressure;
		this.temperature = temperature;
		this.humidity = humidity;
		notifyObservers();
	}
}
