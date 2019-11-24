package study.datastructures.list.linkedlist;

import java.util.Stack;

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
		// linkedList.update(new Node(2, "修改"));
		// System.out.println("修改完的链表：");
		// linkedList.list();

		// 删除节点
		// linkedList.remove(new Node(2,"5"));
		// linkedList.remove(new Node(1,"5"));
		// linkedList.remove(new Node(4,"5"));
		// linkedList.remove(new Node(3,"5"));
		// System.out.println("删除完的链表：");
		// linkedList.list();

		// 获取链表长度
		// System.out.println("链表长度:");
		// System.out.println(size(linkedList));

//		System.out.println("倒数第3个节点是:");
//		System.out.println(findLastIndexNode(3, linkedList));
		
		// 反转
//		System.out.println("反转后:");
//		reverseList(linkedList).list();
		
		// 逆序打印
		System.out.println("逆序打印：");
		reversePrint(linkedList);
	}

	/**
	 * 获取单链表有效节点的个数
	 * 
	 * @return 单链表有效节点的个数
	 */
	public static int size(SingleLinkedList list) {
		Node tempNode = list.getHead().next;

		int size = 0;
		while (tempNode != null) {
			size += 1;
			tempNode = tempNode.next;
		}
		return size;
	}

	/**
	 * 查找单链表中倒数第index的节点
	 * 
	 * @param index
	 *            index
	 * @param list
	 *            list
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

	/**
	 * 反转链表
	 * 
	 * @param list
	 *            待反转的链表
	 * @return
	 */
	public static SingleLinkedList reverseList(SingleLinkedList list) {
		// 创建一个新链表newList
		SingleLinkedList newList = new SingleLinkedList();

		// 遍历list(旧的链表)，得到下一个节点nextNode
		Node nextNode = list.getHead().next;
		while (nextNode != null) {
			// 暂存nextNode.next
			Node tempNode = nextNode.next;
			
			// 把旧链表list的一个个节点插入到新的链表的前面
			Node head = newList.getHead();
			nextNode.next = head.next;
			head.next = nextNode;
			
			// 向下遍历
			nextNode = tempNode;
		}
		
		return newList;
	}
	
	/**
	 * 反向打印链表
	 * @param list 链表
	 */
	public static void reversePrint(SingleLinkedList list) {
		// 定义一个栈
		Stack<Node> stack = new Stack<>();
		
		// 遍历链表,让元素入栈
		Node tempNode = list.getHead().next;
		while (tempNode != null) {
			stack.push(tempNode);
			tempNode = tempNode.next;
		}
		
		// 出栈
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
}
