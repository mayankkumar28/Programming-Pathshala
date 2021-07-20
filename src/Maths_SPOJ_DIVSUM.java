import java.util.Scanner;

public class Maths_SPOJ_DIVSUM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //Running till test cases reduce to zero
        while(t!=0){
            int n = sc.nextInt();
            long sum=1;
            //checking each number from 1 onwards till the square root(halfway) and adding it to sum if divisible
            for (int i =2;i*i<=n;i++){
                if(n%i==0){
                    if (i*i==n){
                        sum = sum+i;
                    }
                    else {
                        sum = sum+i+(n/i);
                    }
                }
            }
            //Handling answer of n=1 separately
            if (n==1) System.out.println(0);
            else System.out.println(sum);
            t--;
        }
    }
}
