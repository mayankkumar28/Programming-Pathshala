import java.util.Scanner;

public class Maths_Codeforces_131C_WorldIsATheatre {
    public static void main(String[] args){
        //Taking inputs
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int t= sc.nextInt();

        //Constructing pascal triangle to find combinations
        int[][] pascal = new int[31][31];
        for (int i = 0;i<pascal.length;i++){
            for(int j = 0;j<=i;j++){
                if (j==0 || j==i) pascal[i][j]=1;
                else {
                    pascal[i][j]= pascal[i-1][j]+pascal[i-1][j-1];
                }
            }
        }

        //Result is sum of [nC4*mCt-4]+ [nC5 * mCt-5] + ..... [nCn * mC1]
        long ans =0;
        for (int i = 4;i<=n;i++){
            if (m<t-i || t-i<1) continue;
            ans+=(long)pascal[n][i]*pascal[m][t-i];
        }
        System.out.println(ans);
    }
}
