import java.util.ArrayList;
import java.util.List;


//More of a Brute force approach
//will start from 0 to size of array and recurse.
//So, basically will freeze and add 0 and try all permutations, then freeze 1 and try all from 0 again
//If an element is already present, it will skip that step. Returns when size is reached

public class Backtracking_Leetcode_46_PermutationsLexico {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backtrack(ans,temp,nums,0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> ans,ArrayList<Integer> temp,int[] nums,int i){
        if (temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j =i;j<nums.length;j++){

            if (temp.contains(nums[j])) continue; //Skipping this step as value already present
            temp.add(nums[j]);
            backtrack(ans,temp,nums,0);
            temp.remove(temp.size()-1); //Removes last element
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }
}
