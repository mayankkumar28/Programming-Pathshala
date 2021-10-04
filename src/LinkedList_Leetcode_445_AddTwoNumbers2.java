import java.util.Stack;
/*
Similar to Leetcode 2 - we are just using a stack to store all nums till the end of the list
we then pop them out one by one, so LSB we will calculated first, till MSB
we reverse the direction of list and return that
 */
public class LinkedList_Leetcode_445_AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        //storing first list
        ListNode curr = l1;
        while (curr != null) {
            s1.push(curr.val);
            curr = curr.next;
        }
        //storing second list
        curr = l2;
        while (curr != null) {
            s2.push(curr.val);
            curr = curr.next;
        }
        //calculating additions till all stacks are empty
        ListNode ans = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int value = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + carry;
            curr = new ListNode(value % 10);
            curr.next = ans;   //reversing the list
            ans = curr;
            carry = value / 10;
        }
        return ans;
    }
}
