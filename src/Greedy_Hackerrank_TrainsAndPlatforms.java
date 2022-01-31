import java.util.Arrays;
import java.util.Scanner;

//Here we sort the arrival and departure time separately
//Using two pointers we check currently how many trains are currently at the station and print the max amount
//When a train departs we do count-- and if arrives we check if the last train has departed or not, if not then count++


public class Greedy_Hackerrank_TrainsAndPlatforms {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrival = new int[n];
        int[] depart = new int[n];
        for (int i = 0; i < n; i++) {
            arrival[i] = sc.nextInt();
            depart[i] = sc.nextInt();
        }
        Arrays.sort(arrival);
        Arrays.sort(depart);
        int count = 0, ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arrival[i] < depart[j]) {
                count++;
                i++;
            } else {
                j++;
                count--;
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}
