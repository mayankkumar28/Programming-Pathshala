import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Easiest way will be to sort both arrays in the ascending order and then compare
To track the original indexes of the array2, we store them in a pair of index,val
We sort both arrays in ascending order and then start comparing nums in array1 and array2.
If a numb in array1 is smaller then a array2 for a index, it will mean that it will also be smaller for further indexes
so it is best to keep this number aside and add it to in front of largest num in array2 later , as it is useless
If we get num in array1 bigger, we store it in index of original num2, and compare next elements
 */

public class Sorting_Leetcode_870_AdvantageShuffle {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums2.length;
        tuple[] nums2index = new tuple[n];
        for (int i =0; i<n;i++){
            nums2index[i] = new tuple(i,nums2[i]);   //tracking original indexes
        }

        //sorting in ascending order
        Arrays.sort(nums1);
        Arrays.sort(nums2index, (a,b)-> (a.y-b.y));

        int[] ans = new int[n];
        List<Integer> trash = new ArrayList<>();
        Arrays.fill(ans,-1);
        int i=0,j=0;
        while(i<n && j<n){
            if (nums1[i]> nums2index[j].y) {
                ans[nums2index[j].x]= nums1[i];   //greater num, store in orig. index
                i++;
                j++;
            }
            else {
                trash.add(nums1[i]);   //lesser num, save for later and compare next
                i++;
            }
        }
        int q=0;
        for (int p = 0;p<n;p++){
            if (ans[p] == -1){
                ans[p] = trash.get(q);  //storing saved nums in empty places
                q++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        int[] temp = advantageCount(nums1,nums2);
        for (int i:temp ) System.out.print(i+" ");
    }
}
