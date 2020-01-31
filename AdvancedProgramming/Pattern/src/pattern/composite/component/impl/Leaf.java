/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Leaf.java  
 * 作者 王磊 
 * 编写日期 2018年9月4日    
 */
package pattern.composite.component.impl;

import pattern.composite.component.Component;

/**
 * 叶子对象
 * 
 * @version 
 * @author 王磊
 */
public class Leaf extends Component{

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void someOperation() {
	}

}
