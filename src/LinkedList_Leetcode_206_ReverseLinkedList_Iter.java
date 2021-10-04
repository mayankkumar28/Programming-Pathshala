
/*
Iteration version
using three pointers - current, prev and temp we iterate and keep reversing the list
first we store the next element to the temp, then reverse the direction of current to point to prev
then shift, the current will become the temp(shift one place) and the prev will become temp
we do this till current reaches null at the end of linked list
 */

public class LinkedList_Leetcode_206_ReverseLinkedList_Iter {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, temp,prev = null;
        while (current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
