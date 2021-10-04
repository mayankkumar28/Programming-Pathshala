/*
Recursion version
we detach the first node from our string, reverse the rest of the string and then rejoin the first node
so we keep doing recursion till we reach the last node, which is the reversed version of itself
then we start rejoining the detached nodes during backtrack from last to first
 */

public class LinkedList_Leetcode_206_ReverseLinkedList_Recur {
    public ListNode reverseList(ListNode head) {
        ListNode current = head, temp;
        if (current == null || current.next == null) return current;   //current will be null when list is empty=edge case
        temp = current.next;
        current.next=null;
        head = reverseList(temp);
        temp.next=current;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
