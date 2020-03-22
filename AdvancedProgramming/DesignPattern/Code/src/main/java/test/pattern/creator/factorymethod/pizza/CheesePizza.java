/*      
 * 模块编号  
 * 功能描述 
 * 文件名 CheesePizza.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.factorymethod.pizza;

public class CheesePizza extends Pizza {

	public CheesePizza(String name) {
		super(name);
	}
	
	public CheesePizza() {
		this("ChessPizza");
	}

	@Override
	public void prepare() {
		System.out.println(" 给制作奶酪披萨 准备原材料 ");
	}

}
