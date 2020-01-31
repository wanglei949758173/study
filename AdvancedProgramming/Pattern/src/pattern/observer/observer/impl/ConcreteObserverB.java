/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteObserver.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.observer.observer.impl;

import pattern.observer.observer.Observer;

/**
 * 
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteObserverB implements Observer{

	@Override
	public void f() {
		System.out.println("B");
	}

}
