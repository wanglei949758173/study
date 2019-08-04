package study.datastructures.list.linkedlist;

/**
 * 单链表
 * 
 * @author Administrator
 *
 */
public class SingleLinkedList {
	private Node head = new Node(0, "Head节点");

	public Node getHead() {
		return head;
	}

	/**
	 * 按照顺序将node节点插入到链表中
	 * 
	 * @param node node节点
	 */
	public void addByOrder(Node node) {
		// 思路:
		// 1.找到大于node.no的前一个节点
		// 2.设置node.next=大于node.no的节点
		// 3.设置大于node.no的前一个节点prevNode.next=node

		Node currentNode = head;
		boolean nodeIsExist = false;
		while (currentNode.next != null) {
			// next.no > node.no,找到了node.no的前一个节点
			if (currentNode.next.no > node.no) {
				break;
			} else if (currentNode.next.no == node.no) {
				// node已存在
				nodeIsExist = true;
				break;
			} else {
				// next.no < node.no
				currentNode = currentNode.next;
				continue;
			}
		}

		if (nodeIsExist) {
			System.out.println("您所要添加的node节点已经存在!");
		} else {
			node.next = currentNode.next;
			currentNode.next = node;
		}
	}

	/**
	 * 根据node.no修改node.name
	 * 
	 * @param node node
	 */
	public void update(Node node) {
		boolean nodeIsExist = false;

		// 找到要修改的节点
		Node currentNode = head.next;
		while (currentNode != null) {
			if (currentNode.no == node.no) {
				nodeIsExist = true;
				break;
			} else {
				currentNode = currentNode.next;
			}
		}

		// 修改节点
		if (nodeIsExist) {
			currentNode.name = node.name;
		} else {
			System.out.println("要修改的node节点不存在");
		}
	}

	/**
	 * 删除node节点
	 * 
	 * @param node node
	 */
	public void remove(Node node) {
		boolean nodeIsExist = false;

		// 找到要删除的节点的上一个节点
		Node currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.next.no == node.no) {
				nodeIsExist = true;
				break;
			} else {
				currentNode = currentNode.next;
			}
		}

		// 删除节点
		if (nodeIsExist) {
			currentNode.next = currentNode.next.next;
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

		Node currentNode = head;
		while (currentNode.next != null) {
			System.out.println(currentNode.next);
			currentNode = currentNode.next;
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
