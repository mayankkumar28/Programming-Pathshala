import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Using lexicographic order, printing all numbers but adding only relevant ones

public class Recursion_Leetcode_1291_SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high){
        List<Integer> ans = new ArrayList<>();
        backtrack(low,high,ans,1);
        Collections.sort(ans);
        return ans;
    }

    public static void backtrack(int low,int high,List<Integer> ans,int index){
        if (index>9) return;
        int temp=0;
        for (int i=index;i<=9;i++){
            temp=temp*10+i;
            //System.out.println(temp);   //Uncomment to see how it works
            if (temp>=low && temp<=high){
                ans.add(temp);
            }
        }
        backtrack(low,high,ans,index+1);
    }

    public static void main(String[] args){
        int low=100,high=3000;
        System.out.println(sequentialDigits(low,high));
    }
}
