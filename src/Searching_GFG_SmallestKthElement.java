/*
We have to find smallest kth element in an array using constant extra space and without changing the array(no sorting)
So basically we do a binary search, we get a count of elements that are less than equal to our key
If count is less, we move to right and if count is more than or equal to k, there are two possibilities
as a number can be repeating, we can get more count as we do less than equal to the number.
So in case of more it can be our answer repeating itself or it can be the number greater
to determine this we check if count of number smaller is less than k, if yes return ans or we move to the right side
 */

public class Searching_GFG_SmallestKthElement {
    public static int search (int[] arr, int k){
        int low = getMin(arr);
        int high = getMax(arr);

        while(low<=high){
            int mid = low+(high-low)/2;
            int cnt = count(arr,mid);
            if (cnt <k) low=mid+1;  //count is less, move right
            else {
                int cnt1 = count(arr,mid-1);
                if (cnt1<k) return mid; //adjacent count is less than k, return ans
                else high = mid-1;  //count is more, move left
            }
        }
        return low;
    }

    //Counting numbers less than or equal to x
    public static int count(int[] arr, int x){
        int count =0;
        for (int j : arr) {
            if (j <= x) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(search(arr,k));
    }

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i:arr) {
            max = Math.max(i,max);
        }
        return max;
    }

    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i:arr) {
            min = Math.min(i,min);
        }
        return min;
    }
}
