/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Adapter.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.adapter.adapter;

import pattern.adapter.adaptee.Adaptee;
import pattern.adapter.target.Target;

/**
 * 适配器
 * 
 * @version 
 * @author 王磊
 */
public class Adapter implements Target{
	
	// 需要被适配的类
	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		System.out.println("新添加了一些处理,调用原方法再处理");
		adaptee.oldFun();
	}
}
