import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointer_Leetcode_349_IntersectOfArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> temp_list = new ArrayList<>();
        int i =0,j=0;

        while (i<n1 && j<n2){
            if (nums1[i]==nums2[j]){
                if (i==0 || nums1[i] != nums1[i-1]){
                    temp_list.add(nums1[i]);
                }
                i++;j++;
            }
            else if (nums1[i]<nums2[j]){   //moving smaller pointer first so that all nums are compared
                i++;
            }
            else j++;
        }

        //Copying arraylist to ans array
        int[] ans = new int[temp_list.size()];
        for (int t=0;t<ans.length;t++){
            ans[t] = temp_list.get(t);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] temp =  intersection(nums1,nums2);
        for (int i :temp) System.out.print(i+" ");
    }
}
