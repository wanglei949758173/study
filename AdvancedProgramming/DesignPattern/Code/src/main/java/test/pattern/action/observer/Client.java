/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年05月16日 
 */
package test.pattern.action.observer;

import test.pattern.action.observer.impl.BaiduSite;
import test.pattern.action.observer.impl.CurrentConditions;
import test.pattern.action.observer.impl.WeatherData;

public class Client {
	public static void main(String[] args) {
		Observer currentCondition = new CurrentConditions();
		Observer baidu = new BaiduSite();
		
		WeatherData weatherData = new WeatherData();
		weatherData.registerObserver(currentCondition);
		weatherData.registerObserver(baidu);
		
		// 更新天气信息
		weatherData.setData(36.2f, 10.0f, 0.6f);
	}
}
