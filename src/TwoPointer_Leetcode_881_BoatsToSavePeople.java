import java.util.Arrays;

/*
Forgot that at max only two people are allowed on the boat, so at max,one of heavier person can always go alone
So, we try to match the heaviest person with the lightest person
If the both are less than limit, we count++ and move on to the next pair
If it is greater, we let go only the heavier person on the boat and try to match the lightest with next heavier and so on
 */

public class TwoPointer_Leetcode_881_BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int low = 0,high = n-1;
        int count =0;
        while(low <= high){
            int sum = people[low] + people[high];
            if (sum <= limit) {     //both can go
                low++;    //only heavier can go
            }
            high--;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] people = {1,2,4,5};
        int limit = 6;
        System.out.println(numRescueBoats(people,limit));
    }
}
