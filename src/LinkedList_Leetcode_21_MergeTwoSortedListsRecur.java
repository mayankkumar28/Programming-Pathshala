/*
Calculate the lesser node of the two, remove it, recurse for remaining lists, and add back
 */

public class LinkedList_Leetcode_21_MergeTwoSortedListsRecur {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;  //edge cases where a list is empty
        if (l2 == null) return l1;
        ListNode head, temp;
        if (l1.val < l2.val){
            head = l1;
            temp = l1.next;
            head.next = null;
            head.next = mergeTwoLists(temp,l2);
        }
        else {
            head = l2;
            temp = l2.next;
            head.next = null;
            head.next = mergeTwoLists(l1,temp);
        }
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
