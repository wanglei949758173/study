/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteStateA.java  
 * 作者 王磊 
 * 编写日期 2018年9月6日    
 */
package pattern.state.state.impl;

import pattern.state.state.State;

/**
 * 状态A
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteStateA implements State {

	@Override
	public void handle(String param) {
		System.out.println("ConcreteStateA handle" + param);
	}

}
