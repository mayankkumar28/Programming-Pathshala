/*
Almost same as Leetcode 234
we first find the mid of the list and then reverse it
then join the first node to last, then, swap first.next node to last, till start becomes null
For 1 -> 2 -> 3 -> 4 -> 5
assign temp to 2, assign 1 -> 5 and move end to temp (2),and start to next (5), then 5 -> 2 and so on
 */

public class LinkedList_Leetcode_143_ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode mid = getmid(head);
        ListNode end = reverseList(mid);
        ListNode start = head;
        while (start != null){
            ListNode temp = start.next;
            start.next = end;   //only this step assigns value to the end one
            start = start.next;  //move start to right, this is now 5 -> 4 -> 3
            end = temp;
        }
    }

    public static ListNode getmid(ListNode head){
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head){
        ListNode curr = head,temp;
        if (curr == null || curr.next ==null) return curr;
        temp = curr.next;
        curr.next = null;
        head = reverseList(temp);
        temp.next = curr;
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