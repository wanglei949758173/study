/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Context.java  
 * 作者 王磊 
 * 编写日期 2018年9月6日    
 */
package pattern.state;


import pattern.state.state.State;
import pattern.state.state.impl.ConcreteStateA;
import pattern.state.state.impl.ConcreteStateB;

/**
 * Context
 * 
 * @version 
 * @author 王磊
 */
public class Context {
	
	private State state = null;
	
	public void request(int state) {
		if (state == 0) {
			this.state = new ConcreteStateA();
		} else {
			this.state = new ConcreteStateB();
		}
		
		this.state.handle(" state " + state);
	}
}
