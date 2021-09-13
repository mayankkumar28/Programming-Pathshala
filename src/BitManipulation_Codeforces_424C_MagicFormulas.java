import java.util.Scanner;

public class BitManipulation_Codeforces_424C_MagicFormulas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int[] prefix = new int[n+1];
        for (int i =0;i<n;i++){
            int x = sc.nextInt();
            ans ^= x;
        }
        for (int i =1;i<=n;i++){
            prefix[i] = i^prefix[i-1];
        }
        for (int i = 1;i<=n;i++){
            if((n/i)%2 == 0) ans ^= prefix[n%i];
            else ans ^= (prefix[n%i]^prefix[i-1]);
        }
        System.out.println(ans);
    }
}