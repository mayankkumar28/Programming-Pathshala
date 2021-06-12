import java.util.Scanner;

public class Codeforces_776B_SherlockAndHisGF {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Taking input
        int n  = sc.nextInt()+1;

        //Using sieve and marking prime number with 1 and others with 2
        int[] primes = new int[n+1];
        for (int i=2;i<=n;i++){
            primes[i]=1;
        }
        for (int i=2;i*i<=n;i++){
            if (primes[i]==1){
                for(int j=i;j*i<=n;j++){
                    primes[i*j]=2;
                }
            }
        }

        //Output 1 if only primes are there
        if (n<4) {
            System.out.println(1);
        }
        else System.out.println(2);

        //Printing sieve output with marked primes and consonants
        for (int i =2;i<=n;i++){
            System.out.print(primes[i] +" ");
        }
    }
}
