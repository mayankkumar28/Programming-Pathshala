import java.util.ArrayList;
import java.util.List;

public class GFG_PrimeFactorizationQueries {
    static List<Integer> primeFactors(int N){
        List<Integer> ans = new ArrayList<>();
        List<Integer> factor =new ArrayList<>();

        //Handling edge case
        if (N<=1) {
            ans.add(0);
            return ans;
        }

        //Sieve of Eratosthenes
        int[] spf =new int[N+1];
        for (int i = 1;i<=N;i++){
            spf[i]=-1;
        }
        for (int i=2;i*i<=N;i++){
            if (spf[i]==-1){
                for (int j =i; j*i<=N;j++){
                    if (spf[i*j]==-1){
                        spf[i*j]=i;
                    }
                }
            }
        }

        //Prime factorization
        int n1 = N;
        while (spf[n1] != -1){
            factor.add(spf[n1]);
            n1=n1/spf[n1];
        }
        if (n1!=1) factor.add(n1);

        //Counting powers
        for (int i=0;i<factor.size();i++){
            if (factor.get(i)==0) continue;
            int count=0;
            int temp = factor.get(i);
            ans.add(temp);
            for (int j=i;j<factor.size();j++){
                if (temp == factor.get(j)){
                    count++;
                    factor.set(j,0);
                }
                else break;
            }
            ans.add(count);
        }
        return ans;
    }
    public static void main(String[] args){
        int N = 100;
        System.out.println(primeFactors(N));
    }
}
