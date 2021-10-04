/*
An easier method is to use a map and to store two nodes, org and clone, for getting random, we can use the key of map
We first make a clone of nodes in front of the original nodes
For this, we remove the link to the next node of the org list, link it to our clone node and then point the next to the clone
Then we copy our random value, the random value of our current node, will be same as our clone node, which will be the next node
so we can simply point the random value of our clone node to the next node of the random value of the org node
then we unlink the chain, and separate org and clone nodes
 */

public class LinkedList_Leetcode_138_CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        //Inserting a clone node in-front of org. node
        Node cloneHead = null;
        Node temp  = null;
        Node curr = head;
        while (curr != null){
            temp = new Node(curr.val);
            if (curr == head) cloneHead = temp;
            Node t = curr.next;
            curr.next = temp;
            temp.next = t;
            curr = t;
        }

        //copying random values
        curr = head;
        while (curr != null){
            if (curr.random != null){
                curr.next.random = curr.random.next;
            }
            else curr.next.random = null;
            curr = curr.next.next;
        }

        //separating clone nodes and org nodes
        curr = cloneHead;
        Node curr1 = head;
        while (curr != null && curr.next != null){
            Node t = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            curr1.next = t;
            curr1 = curr1.next;
        }
        if (curr1!= null) curr1.next=null;
        return cloneHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


