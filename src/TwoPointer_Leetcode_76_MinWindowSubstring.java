/*
We use two freq arrays for both the strings
We count the freq for both the strings and store it in the respective arrays.
While counting we count no. of distant chars, which will help us in deciding initial window
We choose an initial window which contains all chars of string t in string s
we then start removing an elements, ie chars having freq > required, we then compare, if the length is shorter, we update
else we move on the to element next to the end of our window,ie end++;
 */

public class TwoPointer_Leetcode_76_MinWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t.equals("")) return "";
        int[] freq_s = new int[256];
        int[] freq_t = new int[256];
        int distant_char = 0;
        for (int i =0;i<t.length();i++){
            if (freq_t[t.charAt(i)]==0) distant_char++;
            freq_t[t.charAt(i)]++;
        }

        int c =0, start =0, end=0;
        for (int i =0;i<s.length();i++){
            freq_s[s.charAt(i)]++;
            if (freq_s[s.charAt(i)]==freq_t[s.charAt(i)]) c++;
            if (c==distant_char) {
                end = i;
                break;
            }
        }
        if (c<distant_char) return "";

        int ans_s= start,ans_e = end,minm = end-start+1;
        while(end<s.length()){
            while(freq_s[s.charAt(start)] > freq_t[s.charAt(start)]){  //removing chars
                freq_s[s.charAt(start)]--;  //updating freq of removed chars
                start++;
            }
            if (end-start+1 < minm){   //new smallest window
                minm=end-start+1;
                ans_s = start;
                ans_e = end;
            }
            end++;
            if (end<s.length()) freq_s[s.charAt(end)]++;
        }
        return s.substring(ans_s,ans_e+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s,t));
    }
}
