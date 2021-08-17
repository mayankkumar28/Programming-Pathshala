/*
For stalls sorted in ascending order, we have to calculate the minimum of the max distance possible b/w the cows
All cows must be assigned in a stall
We can binary search distance because if a particular distance is less, then all lesser distance will also be not possible
Similarly if a high distance is not possible, all higher distances will also be not possible
to calculate possible distance we keep track of previous stall and see if the next stall maintains that min. distance or not
if it don't we try next, if it does we change previous to this and count++ the no of cows assigned
if all cows were assigned at the end of the loop of stalls, we return true
 */


import java.util.Arrays;
import java.util.Scanner;

public class Searching_SPOJ_AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t!=0){
            int n = sc.nextInt();
            int n_cows = sc.nextInt();
            int[] stalls = new int[n];
            for (int i =0;i<n;i++){
                stalls[i]= sc.nextInt();
            }
            Arrays.sort(stalls);  //sorting for the logic is required

            int low = stalls[0];
            int high = stalls[stalls.length-1];
            while (low <= high){
                int mid = low+(high-low)/2;
                if (!possible_count(mid,n_cows,stalls)) high = mid-1;  //shifting left
                else low = mid+1;  //shifting right
            }
            System.out.println(high);
            t--;
        }
    }

    public static boolean possible_count(int mid,int n_cows,int[] stalls){
        int previous_stall = stalls[0], count = 1;  //first cow
        for (int i = 1;i<stalls.length;i++){
            if (stalls[i]-previous_stall < mid) continue;
            else {
                count++;
                previous_stall = stalls[i];
            }
        }
        return count>=n_cows;  //true if all cows assigned
    }
}
