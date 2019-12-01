package study.datastructures.list.doublelinkedlist;

public class Test {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.add(new Node("张三", 1));
		list.add(new Node("李四", 2));
		list.add(new Node("王五", 3));
		
		list.list();
		
		System.out.println("--------删除张三----------");
		
		list.remove(new Node("张三", 1));
		list.list();
		
		System.out.println("--------删除王五---------");
		
		list.remove(new Node("王五", 3));
		list.list();
		
		System.out.println("---------添加赵六、马七----------");
		list.add(new Node("赵六", 4));
		list.add(new Node("马七", 5));
		list.list();
		
		System.out.println("--------修改赵六----------");
		list.update(new Node("赵6", 4));
		list.list();
	}
}
