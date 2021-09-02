import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Sorting_Codechef_MAXDIFF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();     //no. of testcases
        while (t!=0){
            int n =sc.nextInt();    //no. of items
            int k = sc.nextInt();    //no. of items in a group
            Integer[] weights = new Integer[n];  //weights array
            int sum =0;  //total weight
            for (int i =0;i<n;i++){
                weights[i]= sc.nextInt();
                sum += weights[i];
            }
            Arrays.sort(weights);   //sorting weights in ascending order
            int sum1=0,sum2=0;
            for (int i = 0;i<k;i++){
                sum1+= weights[i];    //weight carried by child
            }
            sum2=sum-sum1;    //weight carried by chef
            int ans1  = sum2-sum1;

            Arrays.sort(weights, Collections.reverseOrder());  //sorting weights in descending order
            int sum3=0,sum4=0;
            for (int i = 0;i<k;i++){
                sum3+= weights[i];    //weight carried by chef
            }
            sum4=sum-sum3;
            int ans2 = sum3-sum4;
            System.out.println(Math.max(ans1,ans2));   //taking max of the two answer
            t--;
        }
    }
}
