/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Main.java  
 * 作者 王磊 
 * 编写日期 2018年4月25日    
 */
package pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {

		Person person1 = new Person();
		List<String> friends = new ArrayList<String>();
		friends.add("James");
		friends.add("Yao");

		person1.setFriends(friends);

		Person person2 = person1.clone();

		System.out.println(person1.getFriends());
		System.out.println(person2.getFriends());

		// 克隆后，两个对象将不再相互关联
		friends.add("Mike");
		person1.setFriends(friends);
		System.out.println(person1.getFriends());
		System.out.println(person2.getFriends());
	}
}
