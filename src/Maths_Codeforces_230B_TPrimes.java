import java.util.Scanner;

//Can't take whole number because of very large number - 10^12
//a number is T prime only if it is a perfect square of a prime number

public class Maths_Codeforces_230B_TPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] arr = new long[t];
        for (int i = 0; i < t; i++) {
            arr[i]=sc.nextLong();
        }
        for (int i =0;i<arr.length;i++) {
            long number = arr[i];
            int sqr_n = (int) Math.sqrt(number);
            if (number % 2 == 0 && number != 4) {
                System.out.println("NO");
            }
            //YES only if sqr_n is prime and number is perfect square
            else if (sqr_n * sqr_n == (int) number) {
                if (CheckPrime(sqr_n)) System.out.println("YES");
                else System.out.println("NO");
            }
            else System.out.println("NO");
        }
    }

    //Checking if the root of number is Prime or not through sieve
    public static boolean CheckPrime(int sqr_n){
        if (sqr_n==1) return false;
        for (int i =3;i*i<=sqr_n;i+=2){
            if (sqr_n%i==0) return false;
        }
        return true;
    }
}