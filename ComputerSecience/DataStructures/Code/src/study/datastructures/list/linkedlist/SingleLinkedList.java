package study.datastructures.list.linkedlist;

/**
 * 单链表
 * 
 * @author Administrator
 *
 */
public class SingleLinkedList {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addByOrder(new Node(4, "李四"));
		list.addByOrder(new Node(5, "王五"));
		list.addByOrder(new Node(3, "张三"));

		list.list();

	}

	private Node head = new Node(0, "Head节点");

	public Node getHead() {
		return head;
	}

	/**
	 * 按照顺序将node节点插入到链表中
	 * 
	 * @param currentNode
	 *            node节点
	 */
	public void addByOrder(Node currentNode) {
		// 找到一个tempNode
		// 满足tempNode.next.getNo() > currentNode.getNo() || tempNode.next == null
		Node tempNode = getHead();
		while (tempNode.next != null) {
			if (tempNode.next.no > currentNode.no) {
				break;
			} else {
				tempNode = tempNode.next;
				continue;
			}
		}

		currentNode.next = tempNode.next;
		tempNode.next = currentNode;
	}

	public void add(Node node) {
		// 寻找最后一个节点lastNode
		Node lastNode = getHead();
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}

		// lastNode.next = currentNode
		lastNode.next = node;
	}

	/**
	 * 根据node.no修改node.name
	 * 
	 * @param node
	 *            node
	 */
	public void update(Node node) {
		boolean nodeIsExist = false;

		// 找到要修改的节点
		Node tempNode = head.next;
		while (tempNode != null) {
			if (tempNode.no == node.no) {
				nodeIsExist = true;
				break;
			} else {
				tempNode = tempNode.next;
			}
		}

		// 修改节点
		if (nodeIsExist) {
			tempNode.name = node.name;
		} else {
			System.out.println("要修改的node节点不存在");
		}
	}

	/**
	 * 删除node节点
	 * 
	 * @param node
	 *            node
	 */
	public void remove(Node node) {
		boolean nodeIsExist = false;

		// 找到要删除的节点的上一个节点
		Node tempNode = head;
		while (tempNode.next != null) {
			if (tempNode.next.no == node.no) {
				nodeIsExist = true;
				break;
			} else {
				tempNode = tempNode.next;
			}
		}

		// 删除节点
		if (nodeIsExist) {
			tempNode.next = tempNode.next.next;
		} else {
			System.out.println("要删除的node节点不存在");
		}
	}

	/**
	 * 遍历链表
	 */
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空!");
		}

		Node tempNode = head;
		while (tempNode.next != null) {
			System.out.println(tempNode.next);
			tempNode = tempNode.next;
		}
	}
}

class Node {
	/**
	 * 编号
	 */
	public int no;

	/**
	 * 名字
	 */
	public String name;

	/**
	 * 下一个节点
	 */
	public Node next;

	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
}
