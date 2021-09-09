import java.util.Arrays;
/*
Two pointer approach on a sorted array
we encounter two cases when sum can be equal : 5+5 = 10 for a number of 5's & 6+4 for a no. of 6's and 4's
we use n*(n-1)/2 to determine the number of cases in first case
we use count of 6 * count of 4 to determine total no. of 2nd case
 */
public class TwoPointer_GFG_CountSumPair {
    public static int getPairsCount(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int i =0, j=n-1;
        int count =0;
        while (i<j){
            int sum = arr[i]+arr[j];
            if (sum < k) i++;
            else if (sum > k) j--;
            else {
                if (arr[i] == arr[j]) {   //case1
                    int l = j-i+1;
                    count += l*(l-1)/2;
                }
                else {
                    int value1 = arr[i], value2 = arr[j];   //case 2
                    int count1 =0, count2 =0;
                    while(arr[i]==value1) {   //how many first num
                        i++;count1++;
                    }
                    while(arr[j]==value2) {   //how many second num
                        j--;count2++;
                    }
                    count += count1*count2;  //total count
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        System.out.println(getPairsCount(arr, arr.length,6));
    }
}
