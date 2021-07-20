import java.util.*;

//Idea is same as Leetcode 46 Permutations, we are just using a hashset now to store the num we have used once
//By this, we avoid generating duplicates.

public class Backtracking_Leetcode_47_Permutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp= new ArrayList<>();
        for (int i:nums){
            temp.add(i);
        }
        backtrack(ans,temp,0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> ans,ArrayList<Integer> temp,int i){
        System.out.println(temp);
        if (i==temp.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        Set<Integer> check = new HashSet<>();
        for (int j=i;j<temp.size();j++){
            if (check.add(temp.get(j))) {  //Using hashset to avoid duplicates
                Collections.swap(temp, i, j);
                backtrack(ans, temp, i + 1);
                Collections.swap(temp, i, j);
            }
        }
    }

    public static void main(String[] args){
        int[] nums= {1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
