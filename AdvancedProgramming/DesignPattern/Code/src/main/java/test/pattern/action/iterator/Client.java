/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年05月13日 
 */
package test.pattern.action.iterator;

import java.util.Iterator;

import test.pattern.action.iterator.impl.ComputerColleage;
import test.pattern.action.iterator.impl.InfoColleage;

public class Client {
	public static void main(String[] args) {
		Colleage computer = new ComputerColleage();
		Colleage info = new InfoColleage();
		
		System.out.println("计算机学院的系");
		Iterator<Department> computerIterator = computer.createIterator();
		while (computerIterator.hasNext()) {
			System.out.println("    " + computerIterator.next().toString());
		}
		System.out.println();
		
		System.out.println("信息学院的系");
		Iterator<Department> infoIterator = info.createIterator();
		while (infoIterator.hasNext()) {
			System.out.println("    " + infoIterator.next().toString());
		}
	}
}
