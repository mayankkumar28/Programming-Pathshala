import java.util.ArrayList;
import java.util.PriorityQueue;

//Use priority queue in k largest questions
// new comparator to sort in reverse order

public class Heaps_GFG_KLargestElements {
    public static ArrayList<Integer> kLargest(int arr[], int n, int k){
        PriorityQueue <Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : arr) q.add(i);
        while (k>0){
            ans.add(q.poll());
            k--;
        }
        return ans;
    }
}
