/*
For the length K, we can traverse k units and reverse it, then do a recursive call for next elements
the call will terminate when the amount of nodes present is less than k, in which we will return the org nodes

 */

public class LinkedList_Leetcode_25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        //checking whether nodes present is >= k or not
        int count  =0;
        ListNode curr = head;
        while (curr != null && count<k){
            count++;
            curr = curr.next;
        }
        if (count < k) return head;   //less nodes present, return org array

        //Reversing the list till k nodes
        curr = head;
        ListNode prev = null;
        ListNode temp;
        count = 0;
        while (count < k){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        head.next = reverseKGroup(curr,k);  //recursive call for next nodes
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
