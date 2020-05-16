/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Subject.java 
 * 作者 王磊 
 * 编写日期 2020年05月16日 
 */
package test.pattern.action.observer;

public interface Subject {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObservers();
}
