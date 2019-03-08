/**      
 * 模块编号  
 * 功能描述 
 * 文件名 ConcreteSubject.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.observer.subject.impl;

import pattern.observer.observer.Observer;
import pattern.observer.subject.Subject;
/**
 * 主题类的实现
 * 
 * @version 
 * @author 王磊
 */
public class ConcreteSubject extends Subject{

	@Override
	public boolean addObserber(Observer observer) {
		this.observerList.add(observer);
		return true;
	}

	@Override
	public boolean removeObserber(Observer observer) {
		this.observerList.remove(observer);
		return true;
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observerList) {
			observer.f();
		}
	}

}
