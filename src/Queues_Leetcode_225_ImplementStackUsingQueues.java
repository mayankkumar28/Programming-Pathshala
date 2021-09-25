import java.util.LinkedList;
import java.util.Queue;


//Whenever an element is inserted in the queue, it is pushed to last position.

public class Queues_Leetcode_225_ImplementStackUsingQueues {
    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
       q.add(x);
       for (int i=1; i<q.size(); i++){
            q.add(q.remove());
       }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
