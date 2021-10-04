/*
Locate the start of of the first index and start of the last index to be removed during traversal
Join the head of list2 with start and tail of list2 with the end
 */

public class LinkedList_Leetcode_1669_MergeInBetweenLL {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null , end = list1;
        int count = 0;
        while (count < b){  //finding end
            if (count == a-1) start = end;  //found start at a-1
            end = end.next;
            count++;
        }
        start.next = list2;
        while (list2.next != null){  //finding end of list2
            list2 = list2.next;
        }
        list2.next = end.next;
        return list1;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
