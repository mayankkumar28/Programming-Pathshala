import java.util.HashMap;

/*
We see a pattern forming that no. of rows having all values equal, were having also having all nums equal or complementary of their nums
For example - 1,1,0 and 1,1,0 will form equal rows because their nums are equal and after 2 col flips, they will be equal too. i.e. all zeros
0,0,1 and 1,1,0 will form equal rows because their nums are complementary of each other i.e. first all 0's and 2nd all 1's
so we take two strings for each row, we iterate
for first string we compare how many rows are equal to it, by using a map and inc. count of this string each time we find it equal
for second string we compare how many rows are exact complement of it, by same procedure
we then take the count of a specific string having maximum count
 */

public class Hashing_Leetcode_1072_FlipColMaxNumberEqualRows {
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0;i<matrix.length;i++){
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j =0;j<matrix[0].length;j++){
                sb1.append(matrix[i][j]);
                sb2.append(1- matrix[i][j]);
            }
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            map.put(s1, map.getOrDefault(s1,0)+1);
            map.put(s2, map.getOrDefault(s2,0)+1);
        }
        int ans  =0;
        for (int i : map.values()) ans = Math.max(i,ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};
        System.out.println(maxEqualRowsAfterFlips(matrix));
    }
}
