import java.util.ArrayList;
import java.util.List;

//Algo used- Lexicographic Subsets

public class Recursion_Leetcode_77_Combinations {
    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        lexi(ans,temp,n,k,1);
        return ans;
    }

    public static void lexi(List<List<Integer>> ans,ArrayList<Integer> temp,int n,int k,int i){
       //if the temp array is of desired size we add it

        if (temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //we start from the index j+1 every time to generate unique sets
        for (int j=i;j<=n;j++){
            temp.add(j);
            lexi(ans,temp,n,k,j+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        int n =4,k=2;
        System.out.println(combine(n,k));
    }
}
