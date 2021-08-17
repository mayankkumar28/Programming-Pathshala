/*
Choose a number starting from 0, subtract the sum and search for the remaining part using binary search
Two pointer approach is faster-
Choose the lowest and highest index,sum it,if equal break, else increment lowest if low and dec highest if high
 */

public class Searching_Leetcode_167_TwoSum2Sorted {

    //    ======== Binary Search Approach O(Nlog2n) ===========
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = {0,0};
        int n = numbers.length;
        for (int i =0;i<n-1;i++){
            ans[0]=i;
            ans[1]=binarySearch(numbers,i+1,n-1,target-numbers[i]);
            if (ans[1] != -1) break;
        }
        ans[0] +=1;ans[1] +=1;
        return ans;
    }

    public static int binarySearch(int[] arr, int low, int high,int target){
        
        while (low<=high){
            int mid=low+(high-low)/2;
            if (arr[mid]==target) return mid;
            else if(arr[mid]<target) low=mid+1;
            else high =mid-1;
        }
        return -1;
    }

//    ======== Two pointer Approach O(n) ===========
//    public static int[] twoSum(int[] numbers, int target) {
//        int l=0,h=numbers.length-1;
//        while(true){
//            int sum = numbers[l] + numbers[h];
//            if (sum==target) break;
//            else if(sum<target) l++;
//            else h--;
//        }
//    int[] ans = {l+1,h+1};
//    return ans;

    public static void main(String[] args){
        int[] numbers = {-1,0};
        int target = -1;
        int[] temp = twoSum(numbers,target);
        for (int i : temp) System.out.print(i +" ");
    }
}
