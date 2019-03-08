/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.facade;

import pattern.facade.facade.Faced;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		//创建门面
		Faced faced = new Faced();
		faced.simpleFun();
	}
}
