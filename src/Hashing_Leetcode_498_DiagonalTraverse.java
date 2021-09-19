import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
Here we notice that minor diagonals indexes always have equal sums,
so we use a map with sum of index as key, and values of all the diagonals having that sum in a list
we have to reverse the direction of every even diagonal, so we check if sum is even, we reverse the list
at last we take all sum one by one and copy the lists to an array
 */

public class Hashing_Leetcode_498_DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat[0].length;
        int n = mat.length;
        if (n==0) return new int[0];  //edge case test
        int[] ans = new int[m*n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i =0;i<n;i++){
            for (int j =0; j<m;j++){
                int sum = i+j;
                ArrayList<Integer> list = map.getOrDefault(sum,new ArrayList<>());
                list.add(mat[i][j]);
                map.put(sum,list);
            }
        }
        int counter =0;
        for (int i =0;i<=m+n;i++){
            if (map.containsKey(i)){
                ArrayList<Integer> temp =  map.get(i);
                if (i%2==0){  //even diagonal
                    Collections.reverse(temp);
                    for (int j : temp) ans[counter++] = j;
                }
                else for (int j : temp) ans[counter++] = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] temp = findDiagonalOrder(mat);
        for (int i : temp) System.out.print(i+" ");
    }
}
