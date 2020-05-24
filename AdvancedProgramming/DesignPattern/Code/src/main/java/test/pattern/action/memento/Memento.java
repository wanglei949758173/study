/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Memento.java 
 * 作者 王磊 
 * 编写日期 2020年05月24日 
 */
package test.pattern.action.memento;

public class Memento {
	/**
	 * 攻击力
	 */
	private int vit;

	/**
	 * 防御
	 */
	private int def;

	public Memento(int vit, int def) {
		super();
		this.vit = vit;
		this.def = def;
	}

	public int getVit() {
		return vit;
	}

	public int getDef() {
		return def;
	}

}
