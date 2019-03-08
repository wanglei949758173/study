/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Component.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.composite.component;

/**
 * 抽象组件
 * 
 * @version 
 * @author 王磊
 */
public abstract class Component {
	
	protected String name;
	
	public Component(String name) {
		this.name = name;
	}

	public abstract void someOperation();
	
	public void addChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}
	
	public void removeChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}
	
	public Component getChildren(int index) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}
}
