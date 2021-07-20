public class Arrays_Leetcode_41_FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //Assigning every integer less than equal to zero to outside of size of array
        for (int i=0;i<n;i++) {
            if (nums[i]<=0) nums[i]=n+1;
        }

        //Changing index of a number to -ve if found in the array
        for (int i=0;i<n;i++){
            int index = Math.abs(nums[i])-1;
            if (index<n) nums[index]=-Math.abs(nums[index]);
        }

        //if some number found +ve, then index of that number is not present in the array
        for (int i=0;i<n;i++){
            if (nums[i]>0) return i+1;
        }
        // if all index were found in the array
        return n+1;
    }

    public static void main(String[] args){
        int[] nums = {1,0,-1,4};
        System.out.println(firstMissingPositive(nums));
    }
}
