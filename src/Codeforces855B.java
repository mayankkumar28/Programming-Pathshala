package com.company;
import java.util.Scanner;

public class Codeforces855B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long p,q,r;
        p=sc.nextLong();
        q=sc.nextLong();
        r=sc.nextLong();
        long[] array = new long[n];
        for (int i =0; i<n;i++){
            array[i]=sc.nextLong();
        }
        long sum=Long.MIN_VALUE;

        //Prefix Max
        long[] prefix_max = new long[array.length];
        for (int i=0; i<array.length;i++){
            if (i==0){
                prefix_max[i]= p*array[i];
            }
            else {
                prefix_max[i] = Math.max(prefix_max[i - 1], p*array[i]);
            }
        }

        //Suffix Max
        long[] suffix_max = new long[array.length];
        for (int i= array.length-1; i>=0;i--){
            if(i== array.length-1){
                suffix_max[i] = r*array[i];
            }
            else {
                suffix_max[i] = Math.max(suffix_max[i+1],r*array[i]);
            }
        }

        //for middle term, finding max sum
        for(int mid = 0; mid <= array.length-1;mid++){
            sum =Math.max(sum,prefix_max[mid]+q*array[mid]+suffix_max[mid]);
        }
        System.out.println(sum);
    }
}
