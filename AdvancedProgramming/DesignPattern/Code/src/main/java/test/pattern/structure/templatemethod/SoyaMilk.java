/*      
 * 模块编号  
 * 功能描述 
 * 文件名 SoyaMilk.java 
 * 作者 王磊 
 * 编写日期 2020年04月26日 
 */
package test.pattern.structure.templatemethod;

public abstract class SoyaMilk {
	public final void make() {
		select();
		if (needsAddCondiments()) {
			addCondiments();
		}
		soak();
		beat();
	};

	/**
	 * 选材
	 */
	protected abstract void select();

	/**
	 * 添加配料
	 */
	protected void addCondiments() {
	}

	/**
	 * 浸泡
	 */
	protected void soak() {
		System.out.println("浸泡");
	};

	/**
	 * 打碎
	 */
	protected void beat() {
		System.out.println("放到豆浆机打碎");
	};

	protected abstract boolean needsAddCondiments();
}
