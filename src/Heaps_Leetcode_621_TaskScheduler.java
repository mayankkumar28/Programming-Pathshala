import java.util.ArrayList;
import java.util.PriorityQueue;

//Use priority q to sort according to the freq, use elements having greater freq first
//start filling the slots with next greater freq, if the elements have run out, use n which is idle time
//for every element will loose 1 freq, store it in a temp array and then add it again to the pq
//do this till the pq gets empty

public class Heaps_Leetcode_621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for (int i : count) {
            if (i>0) pq.add(i);
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int slot = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            while (slot <=n ) {
                if (pq.isEmpty()){
                    if (temp.size() > 0) {
                        ans += (n-slot+1);
                    }
                    break;
                }
                int x = pq.poll();
                if (x-1 >0) temp.add(x-1);
                ans++;
                slot++;
            }
            for (int i : temp) pq.add(i);
        }
        return ans;
    }
}
