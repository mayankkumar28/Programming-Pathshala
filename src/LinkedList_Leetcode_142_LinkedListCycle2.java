/*
Involves a tricky math concept
Let distance from head to the cycle start node = L1
Distance of the cycle nodes = L2
Distance where slow and fast meet inside the cycle = d;
m and n are no. of circles they have revolved around before meeting
Distance covered by slow pointer = L1 + m*L2 + d
Distance covered by fast pointer = L1 + n*L2 + d
Distance covered by fast will be twice of slow as it is moving at twice speed of slow
L1 + m*L2 + d = 2* (L1 + n*L2 + d)
L1+d = (m-2n) * L2
L1 = constant * L2 -d , Here L2-d is the distance from meeting point to the start point of the cycle
So, after L1 distance, the slow pointer will always be at the starting node !!
 */

public class LinkedList_Leetcode_142_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        Boolean isCycle = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ){
                isCycle = true;
                break;
            }
        }
        if (!isCycle) return null;
        ListNode temp = head;
        while (slow != temp){
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
