//https://practice.geeksforgeeks.org/problems/product-of-primes5328/1

import java.util.ArrayList;

public class GFG_ProductOfPrimes {
    static long primeProduct(long L, long R){
        long ans=1;

        //Making a sieve of prime numbers till square root of R
        int n = (int) Math.sqrt(R);
        ArrayList<Boolean> primes = new ArrayList<>();
        for (int i =0; i<n+1;i++){
            primes.add(true);
        }
        primes.set(1,false);
        primes.set(0,false);
        for (int i =2;i*i<=n;i++){
            if(primes.get(i)){
                for (int j=i;i*j<=n;j++){
                    primes.set(i*j,false);
                }
            }
        }

        //Adding the prime numbers to another Array
        ArrayList<Integer> Primelist = new ArrayList<>();
        for (int i =1;i<=n;i++){
            if(primes.get(i)) Primelist.add(i);
        }

        //Initializing target array sieve
        ArrayList<Boolean> isPrime = new ArrayList<>();
        for (int i =0; i<R-L+1;i++){
            isPrime.add(true);
        }
        //Implementing sieve of target array using prime array above
        //These prime numbers will cross out only in the target array range
        for (int i =0;i<Primelist.size();i++){
            int primenum = Primelist.get(i);
            int k = (int)Math.ceil(1.0*L/primenum);
            for (int j = Math.max(k,2); (long) j*primenum<=R; j++){
                isPrime.set((int)(primenum*j-L),false);
            }
        }

        //taking product of resulting primes and returning answer
        for (int i=0;i<isPrime.size();i++){
            if(isPrime.get(i)) ans=ans*(i+L)%1000000007;
        }
        return ans;
    }
    
    public static void main(String[] args){
        long l = 1,r=5;
        System.out.println(primeProduct(l,r));
    }

}
