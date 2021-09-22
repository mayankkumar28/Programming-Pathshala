import java.util.Arrays;
import java.util.Stack;

/*
Watch video for better visualization
so we determine for a specific index, the number of times it will be a min of different sub-arrays
which will be equal to it's no. elements b/w next smallest element * no. of elements b/w previous smallest element (and equal to)
so we cal nse and pse for each index and iterate through the array calculating sum
 */


public class Stacks_Leetcode_907_SumOfSubArrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        int mod = (int) Math.pow(10,9)+7;
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        //next smaller element
        Arrays.fill(nse,n);
        st.push(0);
        for (int i =1;i<n;i++){
            while(!st.empty() && arr[i]<arr[st.peek()]){
                nse[st.pop()] = i;
            }
            st.push(i);
        }

        //previous smaller element
        st.clear();
        st.push(n-1);
        Arrays.fill(pse,-1);
        for (int i = n-2;i>=0;i--){
            while(!st.empty() && arr[i] <= arr[st.peek()]){
                pse[st.pop()] = i;
            }
            st.push(i);
        }

        //finding sub-arrays
        int ans = 0;
        for (int i =0;i<n;i++){
            long temp = ((long) ((i - pse[i]) % mod) * ((nse[i]-i)%mod) * (arr[i]%mod))%mod;
            ans = (int) ((ans%mod + temp%mod)%mod);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr ={3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
}
