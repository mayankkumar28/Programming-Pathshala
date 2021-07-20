import java.util.ArrayList;
import java.util.List;

//Idea is take every num in combinations, adding and removing them all in recursive loops
//In each loop take a target sum and keep subtracting with next nums,if sum =0 we add it to our list
//we start from same point - j in every loop so that each num will get a chance to be picked more than once

public class Recursion_Leetcode_39_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        CS(ans,temp,target,0,candidates);
        return ans;
    }
    public static void CS(List<List<Integer>> ans,ArrayList<Integer> temp,int sum,int start,int[] candidates){
        if (sum<0) return;  //We our sum has become less than target sum, no need to loop further
        if (sum==0){        //We got our target and add the temp list to main list
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int j=start;j<candidates.length;j++){
            temp.add(candidates[j]);  //Taking first num
            CS(ans,temp,sum-candidates[j],j,candidates); //Combinations of that num
            temp.remove(temp.size()-1);   //Removing that num and moving to next in next loop
        }
    }

    public static void main(String[] args){
        int[] candidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates,target));
    }
}
