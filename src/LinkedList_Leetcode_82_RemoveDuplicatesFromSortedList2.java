public class LinkedList_Leetcode_82_RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, curr = head;
        prev.next = curr;
        while (curr!= null){
            while (curr.next != null && curr.next.val == curr.val){
                curr = curr.next;
            }
            if (prev.next != curr){
                prev.next = curr.next;
                curr = curr.next;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
