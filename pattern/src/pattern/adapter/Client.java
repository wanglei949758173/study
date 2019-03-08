/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.adapter;

import pattern.adapter.adaptee.Adaptee;
import pattern.adapter.adapter.Adapter;
import pattern.adapter.target.Target;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		Target target = new Adapter(new Adaptee());
		
		target.request();
	}
}
