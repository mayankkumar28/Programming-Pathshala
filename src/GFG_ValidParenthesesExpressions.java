import java.util.Scanner;

public class GFG_ValidParenthesesExpressions {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n_para = sc.nextInt();

        //n should always be even for valid parentheses closing. Taking pairs of parentheses.
        if (n_para %2 != 0) System.out.println(0);
        else System.out.println(CatalanNumber(n_para/2));
    }

    //Using binomial theorem, finding catalan number

    public static long CatalanNumber(int pairs){
        long bi = 1;
        int k = pairs;
        int n=2*pairs;

        // bi (n,k) = bi (n,k)
        if (k>n-k) k=n-k;

        // bi = [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for (int i =0;i<k;i++){
            bi = bi*(n-i);
            bi = bi/(i+1);
        }
        //Formula = 1/(n+1) * bi(2n n)
        bi = bi/(pairs+1);
        return bi;
    }

    /*  ====  O(N^2) Function for catalan number ====
    public static int CatalanNumber(int n){
        int[] cnt = new int[n+1];
        cnt[0]=1;
        cnt[1]=1;
        for (int i =2;i<=n;i++){
            cnt[i]=0;
            for (int j =0;j<i;j++){
                cnt[i]+=cnt[j]*cnt[i-1-j];
            }
        }
        return cnt[n];
    } */
}
