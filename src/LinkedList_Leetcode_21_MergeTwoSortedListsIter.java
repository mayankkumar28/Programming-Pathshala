/*
Similar to merge sort that we did in the Sorting portion
We take two pointers and compare them one by one, and moving the lesser pointer to the next node
First we determine the head of the list by comparing heads of the both list
and we use p1 and p2 pointers to compare and tail pointer to assign the path of our linkedin list to the lesser one
This is done in-place and time complexity is O(n) and space is O(1)
 */

public class LinkedList_Leetcode_21_MergeTwoSortedListsIter {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;  //edge cases where a list is empty
        if (l2 == null) return l1;
        //finding our head first
        ListNode head, tail, p1 = l1, p2 = l2;
        if (l1.val < l2.val) {
            head = l1;
            tail = l1;
            p1 = p1.next;
        }
        else {
            head = l2;
            tail = l2;
            p2 = p2.next;
        }
        //comparing and joining in sorted order using tail
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                tail.next = p1;
                p1 = p1.next;
            }
            else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        //case where one of the list gets empty and other is remaining, point tail to the head
        if (p1 != null) tail.next = p1;
        if (p2 != null) tail.next = p2;
        return head;
    }
}
