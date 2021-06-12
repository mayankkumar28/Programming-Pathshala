

//Incomplete


import java.util.Scanner;

public class Codeforces_1034A_EnlargeGCD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        boolean flag=true;

        arr[0]=sc.nextInt();
        int gcd=arr[0];int max_num=arr[0];

        for (int i =1;i<n;i++){
            arr[i]= sc.nextInt();
            gcd=hcf(arr[i],gcd);
            max_num=Math.max(arr[i],max_num);
        }
        for (int i =0;i<n;i++){
            arr[i]=arr[i]/gcd;
            System.out.print(arr[i] +" ");
        }
        System.out.println();


        int new_gcd= sieve(max_num,gcd);
        //int new_gcd=1;
        int count=0;
        int answer=-1;
        for (int i =0;i<n-1;i++) {
            if (arr[i] != arr[i + 1]) {
                flag = false;
                answer=i+1;
            }
        }

        for (int i=0;i<n;i++){
            if (arr[i] % new_gcd == 0) count++;
        }

        if (flag || count==0) {
            System.out.println(answer);
        }
        else System.out.println(n-count);
        System.out.println("count= " +count);
//        System.out.println("max count= " +max_count);

    }
    public static int hcf(int a,int b){
        int max_m=Math.max(a,b);
        int min_m=Math.min(a,b);
        if (min_m==0) return max_m;
        while(max_m%min_m!=0){
            int temp=max_m;
            max_m=min_m;
            min_m=temp%min_m;
        }
        return min_m;
    }

    public static int sieve(int max_sum,int gcd){
        int[] spf=new int[max_sum+1];
        for(int i =1;i<=max_sum;i++){
            spf[i]=1;
        }
        for (int i=2;i*i<=max_sum;i++){
            if(spf[i]==1){
                for (int j =i;i*j<=max_sum;j++){
                    spf[i*j]=i;
                }
            }
        }
        int new_gcd=1;

        for (int i=gcd+1;i<spf.length;i++){
            if(spf[i]==1) {
                new_gcd=i;
                break;
            }
        }
        System.out.println("new gcd =" +new_gcd);
        return new_gcd;
    }
}