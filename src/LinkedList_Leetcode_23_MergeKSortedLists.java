/*
We break down the lists into two halves in each loop till we remain with only one list, and we return that list
then we merge those the last two list, and return the head
we keep doing this recursively till we have done it on all the k lists
 */

public class LinkedList_Leetcode_23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeK(lists,0, lists.length-1);
    }

    public static ListNode mergeK (ListNode[] lists,int i,int  j){
        if (i==j) return lists[i];   //same index means same single list, return that list
        int m = (i+j)/2;  //taking mid and breaking lists in two parts
        ListNode h1 = mergeK(lists,i,m);
        ListNode h2 = mergeK(lists,m+1, j);
        return merge(h1,h2);  //calculating the merge of the last two lists (h1,h2)
    }

    public static ListNode merge(ListNode h1, ListNode h2){
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        ListNode head, temp;
        if (h1.val < h2.val) {
            head = h1;
            temp = h1.next;
            head.next = null;
            head.next = merge(temp,h2);
        }
        else {
            head = h2;
            temp = h2.next;
            head.next = null;
            head.next = merge(temp,h1);
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
