public class Leetcode_1175_PrimeArrangements {

    public static void main(String[] args){
        int n =100;
        System.out.println(numPrimeArrangements(n));
    }
    //Counting primes using sieve. Solution is primes! * composites!
    public static int numPrimeArrangements(int n) {
        long m = (long) (Math.pow(10,9)+7);
        int n_primes = PrimeNum(n);
        int n_comp= n-n_primes;
        return (int) ((factorial(n_primes)%m*factorial(n_comp)%m)%m);

    }
    //construction of sieve
    public static int PrimeNum(int n){
        boolean[] primes = new boolean[n+1];
        primes[0]=false; primes[1]=false;
        for (int i =2;i<=n;i++){
            primes[i]=true;
        }

        for (int i =2;i*i<=n;i++){
            if (primes[i]){
                for (int j=i;j*i<=n;j++){
                    primes[i*j]=false;
                }
            }
        }
        int count=0;
        for (int i=2;i<=n;i++){
            if (primes[i]) count++;
        }
        return count;
    }

    //Factorial function
    public static long factorial(int m){
        long mod = (long) (Math.pow(10,9)+7);
        if (m==0) return 1;
        else return (m%mod)*(factorial(m-1)%mod)%mod;
    }
}
