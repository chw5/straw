package leetcode;

/**
 * @Author : wzq
 * @Date : 2023/3/9
 * @Version : 1.0
 * @Description : 两数求和
 * https://leetcode.cn/problems/add-two-numbers/?favorite=2cktkvj
 **/
public class T2 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int a = 0;//进位
        while (l1 != null || l2 != null) {

            //两个链表对齐时l1和l2的各位的数字
            int x = l1 == null ? 0 : l1.val;//l1链表
            int y = l2 == null ? 0 : l2.val;//l2链表

            int sum = a + x + y;//两数求和

            a = sum / 10;//进位

            cur.next = a == 1 ? new ListNode(sum % 10) : new ListNode(sum);//该位求和的结果

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            cur = cur.next;
        }
        //最高位是否有进位
        if (a == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;
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
