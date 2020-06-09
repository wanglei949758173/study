/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestHashTable.java 
 * 作者 王磊 
 * 编写日期 2020年06月07日 
 */
package study.datastructures.hashTable;

import java.util.Scanner;

public class TestHashTable {
	public static void main(String[] args) {
		// 创建HashTable
		HashTable hashTable = new HashTable(7);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add: 添加雇员");
			System.out.println("list: 显示雇员");
			System.out.println("find: 查找雇员");
			System.out.println("del: 删除雇员");
			System.out.println("exit: 退出系统");

			// 获取命令
			String command = scanner.next();
			switch (command) {
			case "add":
				System.out.println("输入 id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTable.add(emp);
				break;
			case "list":
				hashTable.list();
				break;
			case "find":
				System.out.println("请输入要查找的 id");
				id = scanner.nextInt();
				hashTable.findById(id);
				break;
			case "del":
				System.out.println("请输入要删除的雇员的 id");
				id = scanner.nextInt();
				hashTable.removeById(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
		}
	}
}
