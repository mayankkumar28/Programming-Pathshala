//Just make two separate lists, for odd indexes and even indexes, and then join them

public class LinkedList_Leetcode_328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head, even = head.next, evenStart = even;
        while (even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenStart;
        return head;
    }
}
