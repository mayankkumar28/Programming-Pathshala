import java.util.Arrays;
import java.util.Stack;

/*
we iterate through the string and populate a stack which contains non-duplicates chars
during iteration if we encounter a char which is smaller than top of our stack,
and top of stack has freq greater than one(will occur again as we iterate) we keep popping till this condition is satisfied
we maintain a freq array which is the freq of occurrence of all chars in string
and present array which tells us whether a char is currently present inside our stack or not
the ans will our chars stored in the stack (from bottom to top)
 */

public class Stacks_Leetcode_316_RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] freq = new int[26];
        for (int i =0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        boolean[] present = new boolean[26];
        Arrays.fill(present,false);
        st.push(s.charAt(0));
        freq[s.charAt(0)-'a']--;
        present[s.charAt(0)-'a']=true;
        for (int i = 1;i<s.length();i++){
            freq[s.charAt(i)-'a']--;
            if (present[s.charAt(i)-'a']) continue;
            while (!st.empty() && s.charAt(i)<st.peek() && freq[st.peek()-'a']>0){
                present[st.peek()-'a']=false;
                st.pop();
            }
            st.push(s.charAt(i));
            present[s.charAt(i)-'a']=true;
        }

        StringBuilder sb = new StringBuilder();
        for (char i : st) sb.append(i);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
}
