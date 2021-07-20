import java.util.ArrayList;
import java.util.List;

//We are doing depth-first search till we reach the end of the string and then backtrack to generate solution
//The idea is to check the present string to be palindrome or not.
//If it is palindrome then add it to our temp list and do dfs from that index onwards and adding till we reach the end
//Tree for AAB is =>
//                      AAB                              start from 0... first loop is =>
//          /             \               \
//      'A' yes        'AA' yes          'AAB no         add a, yes, then start from 1
//     /        \            \
//   A'A' yes    A'AB' No     AA'B' yes                  add a, yes, then start from 2,
//    /
// AA'B'yes                                              add b,yes,backtrack and store temp in ans,


public class Backtracking_Leetcode_131_PalindromePartitioning {
    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        backtrack(ans,temp,s,0);
        return ans;
    }

    public static void backtrack(List<List<String>> ans,ArrayList<String> temp,String s, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i =start;i<s.length();i++){
            if (isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                backtrack(ans,temp,s,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "aab";
        System.out.println(partition(s));
    }
}
