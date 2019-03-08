/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Originator.java  
 * 作者 王磊 
 * 编写日期 2018年9月18日    
 */
package pattern.memento.originator;

import pattern.memento.memento.Memento;

/**
 * 原发器
 * 
 * @version
 * @author 王磊
 */
public class Originator {
	private String state = "";

	public Memento createMemento() {
		return new MementoImpl(state);
	}
	
	public void setMemento(Memento memento) {
		MementoImpl mementoImpl = (MementoImpl) memento;
		this.state = mementoImpl.getState();
	}

	private static class MementoImpl implements Memento {
		private String state = "";

		public MementoImpl(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}
	}
	
	
	public void phase1() {
		this.state = "phase1";
		System.out.println("phase1 state: " + state);
	}
	
	public void phase1_1() {
		System.out.println("phase1_1 state: " + state);
		this.state = "phase1_1";
		System.out.println("当前 state: " + state);
	}
	
	public void phase1_2() {
		System.out.println("phase1_2 state: " + state);
		this.state = "phase1_2";
		System.out.println("当前 state: " + state);
	}
}
