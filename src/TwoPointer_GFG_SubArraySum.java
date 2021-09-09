import java.util.ArrayList;
/*
Using two pointers starting from zero, we do a current sum
if current sum is less, we increase our range i.e j++, and take care of edge case where j<n
if current sum is more, we decrease our range i.e i++ and take care of case where i could be greater than j
in that case, we inc. j and take a new sum equal to num at j because all previous were not useful to us
we can do it in linear time because once we inc. j we don't need to reset it because all sum before it will also be smaller
 */

public class TwoPointer_GFG_SubArraySum {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        int sum = arr[0];
        while(j<n){
            if (sum < s){
                j++;
                if (j<n) sum += arr[j];
            }
            else if (sum > s) {
                sum -= arr[i];
                i++;
                if (i>j) {
                    j++;
                    if (j<n) sum = arr[j];
                }
            }
            else {
                ans.add(i+1);
                ans.add(j+1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,7,5};
        int s = 12;
        System.out.println(subarraySum(arr, arr.length, s));
    }
}
