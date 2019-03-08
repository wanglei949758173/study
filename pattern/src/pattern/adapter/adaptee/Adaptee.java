/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Adaptee.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.adapter.adaptee;
/**
 * 需要被适配的类
 * 
 * @version 
 * @author 王磊
 */
public class Adaptee {
	public void oldFun() {
		System.out.println("我是原有方法");
	}
}
