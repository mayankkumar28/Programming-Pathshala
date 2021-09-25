import java.util.Stack;
/*
Easier method will be using two stacks, for pop transfer all elements from s1 to s2 and pop the front element and then transfer it back
in optimised approach, instead of transferring back, we use that to pop whether elements
in case of push, we push it to the other stack (s1)
in case s2 gets empty again due to popping, we again transfer all elements from s1 to s2
this will give amortised time complexity of O(1) as we don't need to transfer each time we pop
we maintain front as top element of s2,for peeking, if s2 is empty, front will be the bottom of s1
 */

public class Queues_Leetcode_232_ImplementQueueUsingStack {
    int front; int bottomOfSt1;
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public void push(int x) {
        if (st1.empty() && st2.empty()) front = x;
        else if (st1.empty()) bottomOfSt1 =x;
        st1.push(x);
    }

    public int pop() {
        int ans;
        if (st2.empty()){
            while (!st1.empty()){
                st2.push(st1.pop());
            }
        }
        ans = st2.pop();
        if (!st2.empty()) front = st2.peek();
        else if (!st1.empty()) front = bottomOfSt1;
        return ans;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return st1.empty()&&st2.empty();
    }
}
