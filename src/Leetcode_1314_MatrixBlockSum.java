public class Leetcode_1314_MatrixBlockSum {
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] sum = new int[m+1][n+1];
        //prefix sum
        for (int r =1; r<=m; r++){
            for (int c=1; c<=n; c++){
                sum[r][c] = mat[r-1][c-1]+sum[r-1][c]+sum[r][c-1]-sum[r-1][c-1];
            }
        }
        int[][] ans = new int[m][n];
        for (int r=0;r<m;r++){
            for (int c=0;c<n;c++){
                int r1=Math.max(0,r-k); int r2=Math.min(m-1,r+k);
                int c1=Math.max(0,c-k); int c2=Math.min(n-1,c+k);
                ans[r][c]=sum[r2+1][c2+1]-sum[r1][c2+1]-sum[r2+1][c1]+sum[r1][c1];
            }
        }
        
        //Print
        for (int r =0; r<m; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(ans[r][c] +" ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args){
        int[][] mat = {{67,64,78},{99,98,38},{82,46,46},{6,52,55},{55,99,45}};
        int k =3;
        matrixBlockSum(mat,k);
    }
}