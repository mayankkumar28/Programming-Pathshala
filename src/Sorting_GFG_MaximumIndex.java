import java.util.Arrays;

/*
Getting TLE because we of TC NlogN, but the logic is correct. We can calculate p_min and s_max to find in O(n) time
we remember the org indexes of array before sorting using a tuple of x = value and y =index
we sort the tuple array in ascending order and stable sorting (first occurrence comes first)
As the array is sorted, we start from right side(largest num) and keep moving left, subtracting original indexes
as we traverse we keep updated a original max index and keep taking max value of the answer
 */


public class Sorting_GFG_MaximumIndex {
    public static int maxIndexDiff(int arr[], int n) {
        tuple[] org_arr = new tuple[n];
        for (int i = 0;i<n;i++){
            org_arr[i] = new tuple(arr[i],i);
        }
        Arrays.sort(org_arr, (a,b) -> {
            if(a.x != b.x) return a.x-b.x;
            else return a.y-b.y;   //for stable sort
        });
        int ans = Integer.MIN_VALUE;
        int max_index = org_arr[n-1].y;
        for (int i = n-2; i>=0; i--){
            ans = Math.max(ans, max_index-org_arr[i].y);
            max_index = Math.max(max_index,org_arr[i].y);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(arr,arr.length));
    }
}
