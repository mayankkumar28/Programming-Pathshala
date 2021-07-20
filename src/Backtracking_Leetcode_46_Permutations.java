import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//We are taking two indexes i and j and swapping the elements of array to generate combinations.
//Then un-swap to retain the original array
//for array [1,2,3] we freeze 1 first then swaps, then freeze 2 at index 1 then swaps, freeze 3 at index 1 and so on..
// [1,2,3] => [1,2,3] => [1,3,2]   i,j => 0,0 => 1,1 => return => 1,2 => return
// [1,2,3] => [2,1,3] => [2,3,1]   i,j => 0,1 => 1,1 => return => 1,2 => return
// [1,2,3] => [3,2,1] => [3,1,2]   i,j => 0,2 => 1,1 => return => 1,2 => return

public class Backtracking_Leetcode_46_Permutations {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        //Copying nums array into an arraylist for easy addition to List of List
        for (int i:nums){
            temp.add(i);
        }
        backtrack(ans,temp,0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> ans,ArrayList<Integer> temp,int i){
        if (i == temp.size()-1){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j =i;j<temp.size();j++){
            Collections.swap(temp,i,j);  //Swapping index i and j
            backtrack(ans,temp,i+1);
            Collections.swap(temp,i,j);  //Un-swapping index i and j
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }
}
