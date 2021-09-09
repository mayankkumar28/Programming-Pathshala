import java.util.Arrays;

/*
Almost same as Counting sum pair
we encounter two cases when sum can be equal : 5-5 = 0 (if k is 0) for a number of 5's
& 6-4 for a no. of 6's and 4's if k is 2
we use n*(n-1)/2 to determine the number of cases in first case
we use count of 6 * count of 4 to determine total no. of 2nd case
As we are counting only unique pairs, we only inc. count by i, i and j are already inc. in such a way to avoid duplicates
 */

public class TwoPointer_GFG_CountDiffPair {
    public static int TotalPairs(int[] nums, int k){
        Arrays.sort(nums);
        int i =0, j=1, count = 0;
        int n = nums.length;
        while(j<n){
            int diff = Math.abs(nums[j]-nums[i]);
            if (diff < k) j++;
            else if (diff > k) {
                i++;
                if (i==j) j++;
            }
            else {
                int p = nums[i], q = nums[j];
                if (diff==0){
                    while(i<n && nums[i]==p) { i++; j++; }   //moving both pointers right to avoid duplicates
                    count ++;   //we do only count++ because we want unique pair
                }
                else {   //
                    while (i<n && nums[i]==p) i++;   //avoiding duplicates
                    while (j<n && nums[j]==q) j++;   //avoiding duplicates
                    count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 1, 2};
        //int[] nums = {12, 9, 10, 13, 1, 8, 11};
        System.out.println(TotalPairs(nums,7));
    }
}
