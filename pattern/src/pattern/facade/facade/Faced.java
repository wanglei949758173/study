/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Faced.java  
 * 作者 王磊 
 * 编写日期 2018年8月15日    
 */
package pattern.facade.facade;

import pattern.facade.model.ModuleA;
import pattern.facade.model.ModuleB;

/**
 * 门面
 * 
 * @version 
 * @author 王磊
 */
public class Faced {
	public void simpleFun() {
		ModuleA a = new ModuleA();
		ModuleB b = new ModuleB();
		a.moduleA();
		b.moduleB();
	}
}
