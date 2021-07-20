import java.util.ArrayList;
import java.util.List;

//Using Bitmasking technique
//As we have two choices for each num in array Y or N, we can use bitmasking to print out the number
//For 3 nums _ _ _ 0 0 0 gives blank set and 1 1 1 gives Yes to all three numbers, 1 0 1 will give 1st and 3rd num

public class Recursion_Leetcode_78_SubsetsBitMask {
    public static List<List<Integer>> subsets(int[] nums) {
        //Main List
        List<List<Integer>> output = new ArrayList<>();
        //Temp array
        ArrayList<Integer> temp = new ArrayList<>();
        int n = nums.length;
        int num_sets= (int) Math.pow(2,n);

        //Outer loops creates all bit masks and inner loop iterate over each num in the array
        for (int i =0;i<num_sets;i++){
            for (int j =0;j<n;j++){
                //checking if AND of shifting 1 by j places give 1. If so, we pick that num for our sub-array
                if((i & (1 << j)) > 0){
                    temp.add(nums[j]);
                }
            }
            output.add(new ArrayList<>(temp));
            temp.clear();
        }
        return output;
    }

    public static void main(String[] args){
        int[] nums= {1,2,3};
        System.out.println(subsets(nums));
    }
}
