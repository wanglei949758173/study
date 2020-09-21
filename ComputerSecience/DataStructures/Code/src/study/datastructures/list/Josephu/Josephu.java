/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Josephu.java 
 * 作者 王磊 
 * 编写日期 2020年09月20日 
 */
package study.datastructures.list.Josephu;

import java.util.LinkedList;

public class Josephu {
	public int solution_linkedlist(int childNum, int outNum) {
		if (childNum <= 0 || outNum <= 0) {
			return -1;
		}
		// 初始化链表
		LinkedList<Integer> childs = new LinkedList<>();
		for (int i = 0; i < childNum; i++) {
			childs.add(i + 1);
		}

		// 当未出队孩子数量超过1时,寻找出队孩子的序号,进行出队
		int removeIndex = 0;
		while (childs.size() > 1) {
			removeIndex = (removeIndex + (outNum - 1)) % childs.size();
			Integer removeChild = childs.remove(removeIndex);
			System.out.println(removeChild);
		}

		return childs.get(0);
	}

	public static void main(String[] args) {
		new Josephu().solution_linkedlist(5, 2);
	}
}
