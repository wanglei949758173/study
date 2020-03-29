/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Voltage220V.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package test.pattern.structure.adapter.classadapter;

public class Voltage220V {
	// 输出220V的电压
	public int output220V() {
		int src = 220;
		System.out.println("电压=" + src + "伏");
		return src;
	}
}
