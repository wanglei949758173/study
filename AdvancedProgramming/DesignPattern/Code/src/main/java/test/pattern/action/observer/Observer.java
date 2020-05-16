/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Observer.java 
 * 作者 王磊 
 * 编写日期 2020年05月16日 
 */
package test.pattern.action.observer;

public interface Observer {
	/**
	 * 更新天气信息
	 * @param temperature	温度
	 * @param pressure		气压
	 * @param humidity		湿度
	 */
	void update(float temperature, float pressure, float humidity);
}
