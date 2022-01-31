import java.util.*;

//first we insert the first array into the heap
//then pick out the smallest pair, and replace it with the second array element with the next index

public class Heaps_Leetcode_373_FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 == 0 || len2 == 0) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(len1, k); i++) q.offer(new int[]{nums1[i], nums2[0], 0});
        for (int i = 0; i < Math.min(len1 * len2, k); i++) {
            int[] cur = q.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
            if (cur[2] < len2 - 1) {
                int idx = cur[2] + 1;
                q.offer(new int[]{cur[0], nums2[idx], idx});
            }
        }
        return res;
    }
}
