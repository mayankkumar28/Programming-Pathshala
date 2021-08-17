/*
We have to find one repeating element of an array
We can easily can do that by matching their indices. Correct array will have indexes 1 smaller than the value
If any element is repeated, index will shift by 1 and value and index will be same.
so if idx=value if shift high, idx!=val if check our right, if equal we return that else we shift low to there.
 */

public class Searching_GFG_RepeatingElement {
    public static void main(String[] args){
        int[] nums={1,2,3,4,4};
        int ans = find(nums);
        System.out.println(ans);
    }

    public static int find (int[] nums){
        int low=0,high= nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (nums[mid]==mid) high = mid-1;   //present on the left side
            else {
                if (nums[mid+1] == nums[mid]) return nums[mid];  //value found
                else low=mid+1;  //present on right side
            }
        }
        return -1;
    }
}
