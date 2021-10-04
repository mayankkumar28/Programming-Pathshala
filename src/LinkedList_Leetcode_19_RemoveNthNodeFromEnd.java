/*
we take two pointers and separate them by distance n
if p2 points to null, it means we have to remove the first pointer, so we check that
else we keep inc. p1 and p2 till p2 reaches the nth node
at that point, we replace the next node pointed by p1 by it's next of next and return
 */

public class LinkedList_Leetcode_19_RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        int count = 0;
        while(count<n){  //separating p2 by distance n
            p2 = p2.next;
            count++;
        }
        if (p2 == null) return head.next;   //edge case where we remove first node

        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}