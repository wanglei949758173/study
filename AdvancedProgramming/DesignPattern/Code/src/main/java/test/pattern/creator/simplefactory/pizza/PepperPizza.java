/*      
 * 模块编号  
 * 功能描述 
 * 文件名 PepperPizza.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.simplefactory.pizza;

public class PepperPizza extends Pizza {

	public PepperPizza(String name) {
		super(name);
	}
	
	public PepperPizza() {
		this("PepperPizza");
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println(" 给胡椒披萨准备原材料 ");
	}

}
