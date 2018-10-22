package com.coppco.leetCode02;

public class Solution02 {
    /**
     给定两个非空链表来表示两个非负整数。位数按照 逆序 方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

     你可以假设除了数字 0 之外，这两个数字都不会以零开头。

     示例：

     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果
        ListNode result = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode temp = result;
        //进位
        int carry = 0;

        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;

            int sum = x + y + carry;

            carry = sum / 10;

            temp.next = new ListNode(sum % 10);

            temp = temp.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return result.next;
    }
}
