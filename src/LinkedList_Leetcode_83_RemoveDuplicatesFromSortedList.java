//maintain two pointers prev and curr, if prev is equal to curr, remove curr

public class LinkedList_Leetcode_83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head.next, prev = head;
        while (curr != null){
            if (curr.val == prev.val){
                prev.next = curr.next;
            }
            else prev = prev.next;
            curr = curr.next;
        }
        return head;
    }
}
