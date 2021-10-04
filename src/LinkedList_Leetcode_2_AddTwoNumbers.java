/*
Interesting question
So we loop till both of the lists reaches null
we take the l1 head, l2 head and a carry and sum them up
we divide it by 10 and add it to the node, the remainder will be the carry for next iteration
we then return this list
 */

public class LinkedList_Leetcode_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result  = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry> 0){
            int val = (l1!=null? l1.val : 0) + (l2!=null? l2.val:0) + carry;
            result.next = new ListNode(val%10);
            carry = val/10;
            l1 = (l1 == null? l1 : l1.next);
            l2 = (l2 == null? l2 : l2.next);
            result = result.next;
        }
        return head.next;
    }
}
