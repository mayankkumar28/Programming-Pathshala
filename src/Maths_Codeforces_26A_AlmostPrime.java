import java.util.Scanner;

public class Maths_Codeforces_26A_AlmostPrime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //Sieve
        int[] sieve= new int[n+1];
        for (int i =2;i<n+1;i++){
            if (sieve[i]==0){
                for (int j =2;i*j<n+1;j++){
                    sieve[i*j]++;
                }
            }
        }
        //Counting whether sieve increment two times = two prime numbers
        int ans=0;
        for (int i =1;i<n+1;i++){
            if(sieve[i]==2) ans++;
        }
        System.out.println(ans);
    }
}