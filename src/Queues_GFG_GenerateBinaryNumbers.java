import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Idea is to do a recursion starting from 1 and start adding 0 and 1 to it to form new numbers
after 1 is used we remove it from our queue and add 0 and 1 to the next num in the queue and so on
The removal maintains the sorted order (instead of doing dfs of 1) and is called level order traversal
we use count to count the number of nums when have generated
 */

public class Queues_GFG_GenerateBinaryNumbers {
    public static ArrayList<String> generate(int N){
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        int count =0;
        q.add("1");
        while(count < N){
            String x = q.remove();
            ans.add(String.valueOf(x));
            q.add(x.concat("0"));
            q.add(x.concat("1"));
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(generate(N));
    }
}
