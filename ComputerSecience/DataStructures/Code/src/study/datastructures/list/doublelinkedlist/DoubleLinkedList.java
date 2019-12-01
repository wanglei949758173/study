package study.datastructures.list.doublelinkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedList {
	private Node head = new Node(null, null, "Head", -1);

	/**
	 * 添加节点
	 * 
	 * @param node
	 */
	public void add(Node node) {
		// 找到链表的最后一个节点lastNode
		Node lastNode = this.head;
		while (lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}

		lastNode.setNext(node);
		node.setPrev(lastNode);
	}

	/**
	 * 遍历链表
	 */
	public void list() {
		Node currentNode = this.head;
		while (currentNode.getNext() != null) {
			System.out.println(currentNode.getNext());
			currentNode = currentNode.getNext();
		}
	}

	/**
	 * 修改节点
	 * 
	 * @param node
	 */
	public void update(Node node) {
		// 找到待修改的节点updatedNode
		Node updatedNode = this.head.getNext();
		boolean exist = false;
		while (updatedNode != null) {
			if (updatedNode.getNo() == node.getNo()) {
				exist = true;
				break;
			} else {
				updatedNode = updatedNode.getNext();
			}
		}

		if (exist) {
			updatedNode.setName(node.getName());
		} else {
			System.out.println("要修改的节点不存在");
		}
	}

	/**
	 * 删除节点
	 * 
	 * @param node
	 */
	public void remove(Node node) {
		// 找到要删除的节点deletedNode
		Node deletedNode = this.head.getNext();
		boolean exist = false;
		while (deletedNode != null) {
			if (deletedNode.getNo() == node.getNo()) {
				exist = true;
				break;
			} else {
				deletedNode = deletedNode.getNext();
			}
		}

		if (exist) {
			deletedNode.getPrev().setNext(deletedNode.getNext());
			if (deletedNode.getNext() != null) {
				deletedNode.getNext().setPrev(deletedNode.getPrev());
			}
		} else {
			System.out.println("要删除的节点不存在");
		}
	}
}

class Node {
	@Override
	public String toString() {
		return "Node [name=" + name + ", no=" + no + "]";
	}

	public Node(String name, int no) {
		super();
		this.name = name;
		this.no = no;
	}

	public Node(Node prev, Node next, String name, int no) {
		super();
		this.prev = prev;
		this.next = next;
		this.name = name;
		this.no = no;
	}

	private Node prev; // 上一个节点
	private Node next; // 下一个节点

	// data信息
	private String name;
	private int no;

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}
