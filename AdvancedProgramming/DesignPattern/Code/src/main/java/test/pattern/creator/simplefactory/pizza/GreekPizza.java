/*      
 * 模块编号  
 * 功能描述 
 * 文件名 GreekPizza.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.simplefactory.pizza;

public class GreekPizza extends Pizza {

	public GreekPizza(String name) {
		super(name);
	}
	
	public GreekPizza() {
		super("GreekPizza");
	}

	@Override
	public void prepare() {
		System.out.println(" 给希腊披萨 准备原材料 ");
	}

}
