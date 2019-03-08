/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.observer;

import pattern.observer.observer.Observer;
import pattern.observer.observer.impl.ConcreteObserverA;
import pattern.observer.observer.impl.ConcreteObserverB;
import pattern.observer.subject.Subject;
import pattern.observer.subject.impl.ConcreteSubject;

/**
 * 客户端
 * 
 * @version 
 * @author 王磊
 */
public class Client {
	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();
		
		Observer observerA = new ConcreteObserverA();
		Observer observerB = new ConcreteObserverB();
		
		subject.addObserber(observerA);
		subject.addObserber(observerB);
		
		subject.notifyObservers();
	}
}
