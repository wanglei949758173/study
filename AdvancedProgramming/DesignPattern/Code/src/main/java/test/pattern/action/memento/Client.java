/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年05月24日 
 */
package test.pattern.action.memento;

public class Client {
	public static void main(String[] args) {
		GameRole gameRole = new GameRole();
		gameRole.setVit(999);
		gameRole.setDef(300);
		
		System.out.println("打BOSS前英雄属性：");
		gameRole.displayProperties();
		
		// 保存状态
		Memento memento = gameRole.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(0, memento);
		
		System.out.println();
		gameRole.setVit(400);
		gameRole.setDef(12);
		System.out.println("英雄攻击完BOSS后属性：");
		gameRole.displayProperties();
		
		System.out.println();
		System.out.println("英雄属性恢复大攻击BOSS前：");
		gameRole.resetProperties(caretaker.getMemento(0));
		gameRole.displayProperties();
	}
}
