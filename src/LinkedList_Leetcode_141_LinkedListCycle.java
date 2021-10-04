/*
We initialize a fast pointer and a slow pointer, fast will move 2 twice vs slow
if fast reaches null, it means list has an end, otherwise if it matches slow, it has a cycle
 */

public class LinkedList_Leetcode_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
