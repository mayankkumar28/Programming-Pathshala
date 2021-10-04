/*
A mixture of getting middle node and reverse a linked list
we first get the middle node of the linked list and then reverse it from middle onwards, we have to lists now
then we check if start and end nodes of org half and reverse half are same or not
if not we return false, else ture
Org. LL =>  [3,2,1,1,2,3]
rev LL => [3,2,1]-, [1,2,3]rev= [3,2,1]
 */

public class LinkedList_Leetcode_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getmid(head);
        ListNode end = reverseList(mid);
        ListNode start = head;
        while (start != null && end != null){
            if (start.val != end.val) return false;
            start = start.next;
            end = end.next;
        }
        return true;
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