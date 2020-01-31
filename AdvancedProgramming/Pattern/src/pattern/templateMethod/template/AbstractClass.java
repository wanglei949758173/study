/**      
 * 模块编号  
 * 功能描述 
 * 文件名 AbstractClass.java  
 * 作者 王磊 
 * 编写日期 2018年9月5日    
 */
package pattern.templateMethod.template;

/**
 * 抽象的模板
 * 
 * @version 
 * @author 王磊
 */
public abstract class AbstractClass {
	
	private void f1() {
		System.out.println("AbstractClass f1()");
	}
	
	protected abstract void f2();
	
	public void execute() {
		f1();
		f2();
	}
}
