/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年9月5日    
 */
package pattern.templateMethod;

import pattern.templateMethod.template.AbstractClass;
import pattern.templateMethod.template.impl.ConcreteClass;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		AbstractClass templete = new ConcreteClass();
		
		templete.execute();
	}
}
