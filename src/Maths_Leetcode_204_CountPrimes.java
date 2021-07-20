public class Maths_Leetcode_204_CountPrimes {
    public static int countPrimes(int n) {
        if (n<=0) return 0;
        int[] primes =new int[n+1];
        int count=0;
        primes[1]=0;
        for (int i =2;i<=n;i++){
            primes[i]=1;
        }
        for (int i =2;i*i<=n;i++){
            if (primes[i]==1) {
                for (int j=i; i*j<=n;j++){
                    primes[i*j]=0;
                }
            }
        }
        for (int i =1;i<n;i++){
            if (primes[i] ==1) count++;
        }
        return count;
    }
    public static void main(String[] args){
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
