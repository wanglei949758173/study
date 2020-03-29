/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Phone.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.objectadapter;

public class Phone {
	// 充电
	public void charging(IVoltage5V iVoltage5V) {
		if (iVoltage5V.output5V() == 5) {
			System.out.println("电压为5V, 可以充电~~");
		} else if (iVoltage5V.output5V() > 5) {
			System.out.println("电压大于5V, 不能充电~~");
		}
	}
}
