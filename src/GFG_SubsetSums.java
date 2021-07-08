import java.util.ArrayList;
import java.util.Collections;

//Using Lexicographic approach
//Loop runs like this for [2,3,4] =>
//                  0
//        i=1/     i=2\    i=3\
//          2          3       4
//      i=2/  \i=3     \i=3
//       5     6       7
//    i=3/
//     9


public class GFG_SubsetSums {
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        subsum(ans,0,arr,0,N);
        Collections.sort(ans);  //We sort because question needs it
        return ans;
    }

    public static void subsum(ArrayList<Integer> ans, int sum, ArrayList<Integer> arr,int i,int n){
        ans.add(sum);

        if (i==n) return;

        for (int j=i;j<n;j++){
            subsum(ans,sum+arr.get(j),arr,j+1,n);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(4);
        int N= arr.size();
        System.out.println(subsetSums(arr,N));
    }
}
