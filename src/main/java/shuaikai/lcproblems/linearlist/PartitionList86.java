package shuaikai.lcproblems.linearlist;

import shuaikai.datastructure.list.ListNode;
import shuaikai.utils.ListUtils;

public class PartitionList86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        ListNode p = head;
        ListNode prev = dummy;
        while (p != null) {
            if (p.val > x) {
                prev = p;
                p = p.next;
            } else {
                prev.next = p.next;
                p.next = dummy.next;
                dummy.next = p;
                p = prev.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = ListUtils.getList("1,4,3,2,5,2");
        ListUtils.printList(partition(list, 3));
    }
}
