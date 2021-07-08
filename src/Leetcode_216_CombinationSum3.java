import java.util.ArrayList;
import java.util.List;


//Logic is to take numbers from 1 to 9 and keep adding and removing them in recursive loops
//In each loop take a target sum and keep subtracting k times,if sum =0 we add it to our list

public class Leetcode_216_CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n){
        List<List<Integer>> ans = new ArrayList<>(); //Final answer list
        ArrayList<Integer> temp = new ArrayList<>(); //Temp list to store different combinations

        SS(ans,temp,n,1,k,n);
        return ans;

    }

    public static void SS(List<List<Integer>> ans,ArrayList<Integer> temp ,int sum,int i,int k,int n){
        //we don't need to move further if sum is already -ve or we have used all nums once
        if (i>10 || sum<0 ) {
            return;
        }
        //Reached our k size, no need to calculate larger sizes
        if (temp.size()==k){
            if (sum==0) {  // Reached our target, so we add
                ans.add(new ArrayList<>(temp));
            }
            return;
        }


        for(int j =i;j<=9;j++){
            temp.add(j); //adding num
            SS(ans,temp,sum-j,j+1,k,n); //doing combinations of the num
            temp.remove(temp.size()-1); //removing that num
        }
    }

    public static void main(String[] args){
        int k = 9;
        int n = 45;
        System.out.println(combinationSum3(k,n));
    }
}
