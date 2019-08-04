package study.datastructures.list.linkedlist;

/**
 * 单链表测试
 * 
 * @author Administrator
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		Node node1 = new Node(3, "第三位");
		Node node2 = new Node(2, "第二位");
		Node node3 = new Node(4, "第四位");
		Node node4 = new Node(1, "第一位");
		linkedList.addByOrder(node1);
		linkedList.addByOrder(node2);
		linkedList.addByOrder(node3);
		linkedList.addByOrder(node4);
		System.out.println("插入完的链表：");
		linkedList.list();

		// 修改节点
//		linkedList.update(new Node(2, "修改"));
//		System.out.println("修改完的链表：");
//		linkedList.list();

		// 删除节点
//		linkedList.remove(new Node(2,"5"));
//		linkedList.remove(new Node(1,"5"));
//		linkedList.remove(new Node(4,"5"));
//		linkedList.remove(new Node(3,"5"));
//		System.out.println("删除完的链表：");
//		linkedList.list();

		// 获取链表长度
//		System.out.println("链表长度:");
//		System.out.println(size(linkedList));
		
		System.out.println("倒数第3个节点是:");
		System.out.println(findLastIndexNode(3, linkedList));
	}

	/**
	 * 获取单链表有效节点的个数
	 * 
	 * @return 单链表有效节点的个数
	 */
	public static int size(SingleLinkedList list) {
		Node currentNode = list.getHead().next;

		int size = 0;
		while (currentNode != null) {
			size += 1;
			currentNode = currentNode.next;
		}
		return size;
	}

	/**
	 * 查找单链表中倒数第index的节点
	 * 
	 * @param index index
	 * @param list  list
	 * @return
	 */
	public static Node findLastIndexNode(int index, SingleLinkedList list) {
		int size = size(list);

		// 链表为空
		if (size <= 0) {
			return null;
		} else if (index > size) {
			// 索引大于链表长度
			return null;
		} else {
			int count = 0;
			Node currentNode = list.getHead().next;
			while (currentNode != null) {
				if (count == size - index) {
					break;
				} else {
					count++;
					currentNode = currentNode.next;
					continue;
				}
			}
			return currentNode;
		}
	}
}
