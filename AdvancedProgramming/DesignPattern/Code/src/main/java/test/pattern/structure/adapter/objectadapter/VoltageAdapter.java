/*      
 * 模块编号  
 * 功能描述 
 * 文件名 VoltageAdapter.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.objectadapter;

public class VoltageAdapter implements IVoltage5V {

	/**
	 * 220V电压
	 */
	private Voltage220V voltage220V;

	@Override
	public int output5V() {
		if (voltage220V != null) {
			// 获取到220V电压
			int srcV = voltage220V.output220V();
			int dstV = srcV / 44; // 转成 5v
			return dstV;
		} else {
			throw new RuntimeException("voltage220V is null");
		}
	}

}
