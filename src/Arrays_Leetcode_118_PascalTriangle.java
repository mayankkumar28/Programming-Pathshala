import java.util.ArrayList;
import java.util.List;

public class Arrays_Leetcode_118_PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i =0; i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for (int j=0;j<i+1;j++){
                if (j==0 || j==i) row.add(1);
                else row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            ans.add(row);
        }
        System.out.println(ans);
        return ans;
    } 

    public static void main(String[] args){
        int numRows = 5;
        generate(numRows);
    }
}
