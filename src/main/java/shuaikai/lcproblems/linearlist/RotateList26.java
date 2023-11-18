package shuaikai.lcproblems.linearlist;

import java.util.ArrayList;
import java.util.List;
import shuaikai.datastructure.list.ListNode;
import shuaikai.utils.ListUtils;

public class RotateList26 {

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode p = head;
		List<ListNode> nodes = new ArrayList<>();
		while (p.next != null) {
			nodes.add(p);
			p = p.next;
		}
		p.next = head;
		nodes.add(p);

		int step = k % nodes.size();
		int idx = step == 0 ? 0 : nodes.size() - step;
		int prev = idx == 0 ? nodes.size() - 1 : idx - 1;
		nodes.get(prev).next = null;
		return nodes.get(idx);
	}

	public static void main(String[] args) {
		ListNode list = ListUtils.getList("1,2,3,4,5");
		ListUtils.printList(rotateRight(list, 14));
	}
}
