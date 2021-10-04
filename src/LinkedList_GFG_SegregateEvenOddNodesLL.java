/*
We have four pointers each indicating starting and ending nodes of even and odd numbers
We then run loop from start to end
For the first occurrence we initialize our starts of even and odds
then onwards,if the number is odd, we join it next to the oddEnd and if even we join it to EvenEnd
If we attach the end of even to the start of the odd,checking the null conditions, because we need even first
 */

public class LinkedList_GFG_SegregateEvenOddNodesLL {
    Node divide(int N, Node head) {
        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
        Node curr= head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = curr;
                }
                else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            }
            else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = curr;

                }
                else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }
        if (evenStart != null)  evenEnd.next = oddStart;  //oddStart can be null,no problem
        if (oddStart != null)  oddEnd.next = null;  //Attaching null to the end
        if (evenStart == null) return oddStart; //even nums absent
        else return evenStart;
    }

    class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
}
