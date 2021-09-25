import java.util.LinkedList;
import java.util.Queue;

//using a recursive call to, first remove all elements from front,when queue gets empty, start adding them back while backtracking

public class Queues_GFG_ReverseAQueue {
    public static Queue<Integer> rev(Queue<Integer> q){
        if (q.isEmpty()) return q;
        int x = q.remove();
        rev(q);
        q.add(x);
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);q.add(2);q.add(3);
        System.out.println(rev(q));
    }
}
