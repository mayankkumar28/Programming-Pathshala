/*
Here we first create a dummy-node so that we don't have to keep track of our head and point it to our initial head
Then we keep iterating till we reach the end
if on the way we encounter a case where our curr pointer is greater than next pointer,
we first remove our next node which is smaller, ie. point our current pointer to the next to next node of smaller one
we then start from first node of the list, and keep comparing values of nodes with our smaller node,
if we encounter a greater node than our smaller, we stop
we then point our smaller node to that larger node
and then the node which was before the larger node to the smaller node
 */

public class LinkedList_Leetcode_147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preInsert, curr = head, toInsert;
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        while (curr.next != null){
            if (curr.val <= curr.next.val){     //all ok, keep moving
                curr = curr.next;
            }
            else {
                toInsert = curr.next; //take the smaller node
                curr.next = toInsert.next;  //remove smaller node from list
                preInsert = dummyhead;  //initialize locator
                while (preInsert.next.val < toInsert.val){   //find the larger node than our smaller
                    preInsert = preInsert.next;
                }
                toInsert.next = preInsert.next;  //point small to the larger
                preInsert.next = toInsert;  //point pre-larger to the smaller
            }
        }
        return dummyhead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}