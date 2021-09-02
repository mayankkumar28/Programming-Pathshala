import java.util.Scanner;

/*
Kafi jaan lewa question
To increase a portion of an array from specific indexes, we can increase the end point and decrease the one position before start point
this way we can do suffix sum at the end and get the final result in O(n) time, it is used here for inc. votes
We are finding here the vote range of all candidates, instead of how many votes one candidate gets
If the first candidate can vote till i on right side, it means it has sum b/w them <= candidate influence
therefore he can also vote all the candidates before i, same logic can be applied for the left side too.
we can do two binary search (monotonic func.) to determine the range on right and left and side
we inc. votes array accordingly, and then do suffix sum at last to obtain it
we are do prefix sum of influence to obtain the sum b/w two candidates easily
 */


public class Sorting_Codechef_MINVOTE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  //test cases
        while(t!=0){
            int n = sc.nextInt();
            int[] influence = new int[n];
            long[] influence_sum = new long[n];
            int[] votes = new int[n];
            influence[0] = sc.nextInt();
            influence_sum[0] = influence[0];
            for (int i =1; i<n; i++){
                influence[i] = sc.nextInt();
                influence_sum[i] = influence_sum[i-1]+influence[i];
            }

            //finding range of votes of all candidates from 0 to n-1
            for (int i =0; i<n; i++){
                int right_max = rightvotemax(influence_sum,influence,i);  //return right side max which he can't vote
                vote(votes,i+1,right_max-1);   //mark votes b/w them
                if (i==0) continue;  //skipping for i =0 because there is no range on left side
                int left_max = leftvotemax(influence_sum,influence,i);  //return left side max which he can't vote
                vote(votes,left_max+1,i-1);  //mark votes b/w them
            }

            for (int i = n-2;i>=0;i--){    //Suffix sum
                votes[i] += votes[i+1];
            }
            for (int i : votes) System.out.print(i + " ");   //printing votes array
            t--;
        }
    }

    public static int rightvotemax (long[] influence_sum, int[] influence,int i){
        int low = i+1;
        int high = influence.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (influence[i] >= influence_sum[mid-1]-influence_sum[i]) low=mid+1;   //can vote, move right
            else {
                if (influence[i] >= influence_sum[mid-2]-influence_sum[i]) return mid;  //max vote
                else high = mid-1;  //can't vote move left
            }
        }
        return low;
    }

    public static int leftvotemax (long[] influence_sum, int[] influence,int i){
        int low = 0;
        int high = i-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (influence[i] >= influence_sum[i-1]-influence_sum[mid]) high = mid-1;  //can vote, move left
            else {
                if (influence[i] >= influence_sum[i-1]-influence_sum[mid+1]) return mid;
                else low = mid+1; //can't vote, move right
            }
        }
        return high;
    }

    public static void vote(int[] votes, int i, int j){
        if (j<votes.length) votes[j]++;  //inc. last point of range
        if (i>0) votes[i-1]--;   //dec. one point before last point of range
        
    }
}
