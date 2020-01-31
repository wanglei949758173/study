/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Subject.java  
 * 作者 王磊 
 * 编写日期 2018年9月3日    
 */
package pattern.observer.subject;

import java.util.ArrayList;
import java.util.List;

import pattern.observer.observer.Observer;

public abstract class Subject {
	protected List<Observer> observerList = new ArrayList<>();
	
	public abstract boolean addObserber(Observer observer);
	
	public abstract boolean removeObserber(Observer observer);
	
	public abstract void notifyObservers();
}
