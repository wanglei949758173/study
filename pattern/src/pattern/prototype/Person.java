/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Person.java  
 * 作者 王磊 
 * 编写日期 2018年4月25日    
 */
package pattern.prototype;
/**
 * person
 * 
 * @version 
 * @author 王磊
 */

import java.util.ArrayList;
import java.util.List;

public class Person implements Cloneable{
	//姓名
	private String name;
	//年龄
	private int age;
	//朋友
	private List<String> friends;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	public Person clone() {
		try {
			Person person = (Person) super.clone();
			List<String> newfriends = new ArrayList<String>();
			for(String friend : getFriends()) {
				newfriends.add(friend);
			}
			person.setFriends(newfriends);
			return  person;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
