/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Composite.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.composite.component.impl;

import java.util.ArrayList;
import java.util.List;

import pattern.composite.component.Component;

/**
 * 组合对象
 * 
 * @version 
 * @author 王磊
 */

public class Composite extends Component{
	
	public Composite(String name) {
		super(name);
	}

	/**
	 * 用来存储组合对象中包含的子组件对象
	 */
	private List<Component> childComponents = null;

	@Override
	public void someOperation() {
		if (childComponents != null) {
			for (Component component : childComponents) {
				component.someOperation();
			}
		}
	}
	
	@Override
	public void addChild(Component child) {
		if (childComponents == null) {
			childComponents = new ArrayList<>();
		}
		
		childComponents.add(child);
	}
	
	@Override
	public void removeChild(Component child) {
		if (childComponents != null) {
			childComponents.remove(child);
		}
	}
	
	@Override
	public Component getChildren(int index) {
		if (childComponents != null) {
			if (index >= 0 && index < childComponents.size() - 1) {
				return childComponents.get(index);
			}
		}
		return null;
	}

}
