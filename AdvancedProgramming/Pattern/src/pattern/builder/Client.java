/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年8月28日    
 */
package pattern.builder;

import pattern.builder.builder.impl.BuliderTeLa;
import pattern.builder.director.Director;
import pattern.builder.product.Sheep;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		BuliderTeLa teLa = new BuliderTeLa();
		Director director = new Director(teLa);
		director.execute();
		Sheep sheep = teLa.getSheep();
		System.out.println(sheep);
	}
}
