/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Caretaker.java  
 * 作者 王磊 
 * 编写日期 2018年9月18日    
 */
package pattern.memento.caretaker;

import java.util.HashMap;
import java.util.Map;

import pattern.memento.memento.Memento;

/**
 * 备忘录管理者
 * 
 * @version
 * @author 王磊
 */
public class Caretaker {
	private Map<String, Memento> mementoMap;

	public void saveMemento(String key, Memento value) {
		if (mementoMap == null) {
			mementoMap = new HashMap<>();
		}
		mementoMap.put(key, value);
	}

	public Memento getMemento(String key) {
		if (mementoMap == null) {
			return null;
		} else {
			return mementoMap.get(key);
		}
	}
}
