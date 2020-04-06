/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年04月06日 
 */
package test.pattern.structure.decorator;

import test.pattern.structure.decorator.decorator.Chocolate;
import test.pattern.structure.decorator.decorator.Milk;
import test.pattern.structure.decorator.impl.DeCaf;

public class Client {
	public static void main(String[] args) {
		DeCaf decaf = new DeCaf();
		// 加牛奶
		Milk milk = new Milk(decaf);
		System.out.println(milk.getDescription());
		System.out.println(milk.cost());
		
		// 加巧克力
		Chocolate chocolate = new Chocolate(milk);
		System.out.println(chocolate.getDescription());
		System.out.println(chocolate.cost());
	}
}
