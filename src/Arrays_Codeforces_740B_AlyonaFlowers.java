import java.util.Scanner;
/*
The Question is complicated. Basically we have to determine a max output from different chosen sub-arrays
So instead of taking two indexes and iterating and summing each time, we precompute the sum of array from left to right
We then take a temp int where we store the sum of the sub-array, we have the choice to use or discard it
If the sum is positive we chose it, otherwise we discard it, we can discard all of them if we want
We move to next sub-array and keep adding to the sum
 */


public class Arrays_Codeforces_740B_AlyonaFlowers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i]= sc.nextInt();
            sum[i] = arr[i]+sum[i-1];  //Computing array sum from left to right
        }

        int max = 0;
        for (int i =1; i<=m;i++){
            int left =sc.nextInt();  //Left index of sub-array
            int right =sc.nextInt(); //Right index of sub-array
            int temp =0;
            temp = sum[right]-sum[left-1];  //Calculating sub-array sum.
            if (temp>0){   //We choose it if +ve
                max += temp;
            }
        }
        System.out.println(max);
    }
}
