/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Pizza.java 
 * 作者 王磊 
 * 编写日期 2020年03月21日 
 */
package test.pattern.creator.simplefactory.pizza;

public abstract class Pizza {
	protected String name; // 名字

	public Pizza(String name) {
		this.name = name;
	}

	// 准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
	public abstract void prepare();

	public void bake() {
		System.out.println(name + " baking;");
	}

	public void cut() {
		System.out.println(name + " cutting;");
	}

	// 打包
	public void box() {
		System.out.println(name + " boxing;");
	}
}
