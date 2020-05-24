/*      
 * 模块编号  
 * 功能描述 
 * 文件名 GameRole.java 
 * 作者 王磊 
 * 编写日期 2020年05月24日 
 */
package test.pattern.action.memento;

public class GameRole {
	/**
	 * 攻击力
	 */
	private int vit;

	/**
	 * 防御
	 */
	private int def;

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public Memento createMemento() {
		return new Memento(vit, def);
	}

	public void resetProperties(Memento memento) {
		this.vit = memento.getVit();
		this.def = memento.getDef();
	}

	public void displayProperties() {
		System.out.println(String.format("当前攻击力=%d,当前防御=%d", this.vit, this.def));
	}
}
