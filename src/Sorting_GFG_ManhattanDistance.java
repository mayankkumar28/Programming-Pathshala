import java.util.Arrays;

//The shortcut is to calculate total of x and y distances separately and sum them.

public class Sorting_GFG_ManhattanDistance {
    public static int distancesum(int arr[], int n) {
        // sorting the array.
        Arrays.sort(arr);

        // for each point, finding the distance.
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            res += (arr[i] * i - sum);
            sum += arr[i];
        }
        return res;
    }

    public static int totaldistancesum(int x[], int y[], int n) {
        return distancesum(x, n) + distancesum(y, n);
    }

    // Driven Program
    public static void main(String[] args) {
        int x[] = { -1, 1, 3, 2 };
        int y[] = { 5, 6, 5, 3 };
        int n = x.length;
        System.out.println(totaldistancesum(x, y, n));
    }
}
