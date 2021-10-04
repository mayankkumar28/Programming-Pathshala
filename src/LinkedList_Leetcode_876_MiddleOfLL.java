/*
We use two pointers, fast and slow, fast moves twice as fast as slow
So when fast reaches null when total nodes are odd or before null when even, the slow will be at the middle
At that point of time we can return slow
 */

public class LinkedList_Leetcode_876_MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
