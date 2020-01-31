/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年9月18日    
 */
package pattern.memento;

import pattern.memento.caretaker.Caretaker;
import pattern.memento.memento.Memento;
import pattern.memento.originator.Originator;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		// 创建备忘录管理者
		Caretaker caretaker = new Caretaker();
		
		// 创建原发器
		Originator originator = new Originator();
		 
		// 执行第一阶段
		originator.phase1();
		
		// 保存第一阶段的数据
		Memento memento = originator.createMemento();
		caretaker.saveMemento("phase1 state", memento);
		
		// 执行1_1
		originator.setMemento(caretaker.getMemento("phase1 state"));
		originator.phase1_1();
		
		// 执行1_2
		originator.setMemento(caretaker.getMemento("phase1 state"));
		originator.phase1_2();
		
	}
}
