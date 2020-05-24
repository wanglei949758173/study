/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Caretaker.java 
 * 作者 王磊 
 * 编写日期 2020年05月24日 
 */
package test.pattern.action.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	/**
	 * 保存的备忘录列表
	 */
	private List<Memento> mementos = new ArrayList<>();

	public void addMemento(int index, Memento memento) {
		this.mementos.add(index, memento);
	}

	public Memento getMemento(int index) {
		return this.mementos.get(index);
	}
}
