/*      
 * 模块编号  
 * 功能描述 
 * 文件名 VoltageAdapter.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.classadapter;

public class VoltageAdapter extends Voltage220V implements IVoltage5V {

	@Override
	public int output5V() {
		// 获取到220V电压
		int srcV = output220V();
		int dstV = srcV / 44; // 转成 5v
		return dstV;
	}

}
