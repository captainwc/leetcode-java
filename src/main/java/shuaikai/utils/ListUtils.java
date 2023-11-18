package shuaikai.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import shuaikai.datastructure.list.ListNode;

public class ListUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(ListUtils.class);

    public static ListNode getList(String str) {
        List<Integer> nums = Arrays.asList(str.split(",")).stream().map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
        ListNode head = new ListNode(nums.get(0));
        ListNode p = head;
        for (int i = 1; i < nums.size(); i++) {
            p.next = new ListNode(nums.get(i));
            p = p.next;
        }
        return head;
    }

    public static String list2String(ListNode head) {
        StringBuilder builder = new StringBuilder().append("[");
        ListNode p = head;
        while (p.next != null) {
            builder.append(p.val).append(",");
            p = p.next;
        }
        builder.append(p.val).append("]");
        return builder.toString();
    }

    public static void printList(ListNode head) {
        System.out.println(list2String(head));
    }
}
