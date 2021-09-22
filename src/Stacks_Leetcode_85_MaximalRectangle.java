import java.util.Stack;

/*
Same concept as Leetcode 84
Int the first step we calculate the height of the column by taking summations of 1 and cal a sum 2d matrix
then we apply same procedure as to find largest rectangle in histogram
we calculate next smallest and previous smallest index for each index to determine the length of base
and take the diff of them (length of base) multiplied by their height will give max area of rect. of that index
we do this for all the rows present and take max
 */


public class Stacks_Leetcode_85_MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int[][] sum_matrix = new int[matrix.length][matrix[0].length];
        //coping first row to sum matrix
        for (int i =0;i<matrix[0].length;i++){
            if (matrix[0][i]=='1') sum_matrix[0][i]=1;
            else sum_matrix[0][i]=0;
        }
        //taking sums col-wise
        for (int col =0;col<matrix[0].length;col++){
            for (int row =1;row<matrix.length;row++){
                if (matrix[row][col] != '0'){
                    sum_matrix[row][col]=1+sum_matrix[row-1][col];
                }
            }
        }


        //Computing max rectangle
        int max_Rectangle = -1;
        for (int i =0;i<matrix.length;i++){
            int[] nse = nse(sum_matrix[i]);
            int[] pse = pse(sum_matrix[i]);
            for (int j =0;j< matrix[0].length;j++){
                max_Rectangle = Math.max(max_Rectangle,sum_matrix[i][j]*(nse[j]-pse[j]-1));
            }
        }

        return max_Rectangle;
    }

    //next smallest element
    public static int[] nse(int[] heights){
        int n = heights.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for (int i =1;i<n;i++){
            while (!st.empty() && heights[i]<heights[st.peek()]){
                nse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()){
            nse[st.peek()] = n;
            st.pop();
        }
        return nse;
    }

    //previous smallest element
    public static int[] pse(int[] heights){
        int n = heights.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(n-1);
        for (int i =n-2;i>=0;i--){
            while (!st.empty() && heights[i]<heights[st.peek()]){
                pse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()){
            pse[st.peek()] = -1;
            st.pop();
        }
        return pse;
    }

    public static void main(String[] args) {
        char[][] matrix =  {{'1','0','1','0','0'},
                            {'1','0','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
