package leetcode;

/**
 * @Author : wzq
 * @Date : 2023/11/2
 * @Version : 1.0
 * @Desc :合并两个有序链表:https://leetcode-cn.com/problems/merge-two-sorted-lists
 **/
public class T0021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode index = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                index.next = l1;
                l1 = l1.next;
            } else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }
        index.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
