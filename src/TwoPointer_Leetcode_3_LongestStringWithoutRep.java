/*
Take two pointers, and a freq array
If the next element is having freq zero, move and inc. right pointer
else move the left pointer and decrease the freq of of it (not included in the window now)
Do this till right pointer reach the end of the array. Take max of the answers
 */

public class TwoPointer_Leetcode_3_LongestStringWithoutRep {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n<1) return 0;
        int[] freq = new int[256];
        int ans = 1;
        int i = 0, j =0;
        freq[s.charAt(0)]++;
        while (j<n-1){
            if (freq[s.charAt(j+1)]==0) {
                j++;
                freq[s.charAt(j)]++;
            }
            else {
                freq[s.charAt(i)]--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}