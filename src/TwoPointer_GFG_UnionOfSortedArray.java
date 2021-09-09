import java.util.ArrayList;

/*
Using two pointers, pick the smallest one first of the two arrays
If the number is not equal to the previous one, add it to the list
duplicity will be avoided as the array is sorted so, the added num should be unique
copy rest of the nums in list so loop will not iterate over all nums in case of unequal length
 */

public class TwoPointer_GFG_UnionOfSortedArray {
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j=0;
        while (i < n && j<m){
            if (arr1[i] == arr2[j]){
                if (i==0 || arr1[i] != arr1[i-1]){
                    ans.add(arr1[i]);
                }
                i++; j++;
            }
            else if (arr1[i] < arr2[j]){
                if (i==0 || arr1[i] != arr1[i-1]){
                    ans.add(arr1[i]);
                }
                i++;
            }
            else {
                if (j==0 || arr2[j] != arr2[j-1]){
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<n){     //copying rest of nums
            if(i==0 || arr1[i]!=arr1[i-1]) {
                ans.add(arr1[i]);
            }
            i++;
        }
        while(j<m) {    //copying rest of nums
            if (j == 0 || arr2[j] != arr2[j - 1]) {
                ans.add(arr2[j]);
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 2, 3, 4};
        System.out.println(findUnion(arr1,arr2, arr1.length, arr2.length));
    }
}
