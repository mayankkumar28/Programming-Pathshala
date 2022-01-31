import java.util.Arrays;

//We sort the array by the end time and then compare the next meeting start time
//If it's smaller we do count++ and update endMeeting time and return the count

public class Greedy_GFG_Nmeetings {
    public static int maxMeetings(int[] start, int[] end, int n) {
        tuple[] arr = new tuple[n];
        for (int i =0;i<n;i++){
            arr[i] = new tuple(start[i],end[i]);
        }
        Arrays.sort(arr, (a, b) -> a.y-b.y);
        int ans =1;
        int endtime = arr[0].y;
        for (int i =1;i<n;i++){
            if (arr[i].x > endtime ) {
                ans++;
                endtime = arr[i].y;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        System.out.println(maxMeetings(start,end,start.length));
    }
}
