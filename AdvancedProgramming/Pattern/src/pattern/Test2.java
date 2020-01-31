/**      
 * 模块编号  
 * 功能描述 
 * 文件名 Test2.java  
 * 作者 王磊 
 * 编写日期 2018年8月22日    
 */
package pattern;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.iterator();

		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i);
			list.remove(string);
			System.out.println("移除了元素:" + string);
		}
	}
}
