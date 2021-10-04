/*
While iterating through the list, if current node has a child, we point tail of the child to the next node on right
and the head of the child to the curr next (insert it in the main list next to curr)
this way one level has been flattened.
if the child has more levels, it will be flattened will curr will flattened when curr will move to next node (that we just created)
 */

public class LinkedList_Leetcode_430_FlattenMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {   //node has a child
                Node right = curr.next;
                Node temp = curr.child;
                while (temp.next != null) temp = temp.next;  //finding tail
                temp.next = right;
                if (right != null) right.prev = temp;

                //joining child head to curr as next node and removing child
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
            curr = curr.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
