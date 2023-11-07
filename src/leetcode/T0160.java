package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wzq
 * @Date: 2023/11/7
 * @Desc: 相交链表：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 **/
public class T0160 {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA, b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        Set<Object> set = new HashSet<>();
        ListNode aIndex = headA, bIndex = headB;
        while (aIndex != null) {
            set.add(aIndex);
            aIndex = aIndex.next;
        }

        while (bIndex != null) {
            if (set.contains(bIndex)) {
                return bIndex;
            }
            bIndex = bIndex.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
