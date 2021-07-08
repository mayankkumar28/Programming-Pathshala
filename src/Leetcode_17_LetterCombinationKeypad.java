import java.util.ArrayList;
import java.util.List;

public class Leetcode_17_LetterCombinationKeypad {
    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        //Storing the keypad to a String array
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        if (digits.length()==0) return answer;
        combinations(answer,digits,"",0,map);
        return answer;
    }
    public static void combinations(List<String> answer,String digits,String prefix,int i,String[] map){
        if(i>=digits.length()){
            answer.add(prefix);
            return;
        }
        //Offsetting ascii value, i=2 gives string abc, otherwise it chooses ascii value of "2"
        String letters = map[(digits.charAt(i)-'0')];

        //We are looping for each char in string digits
        //We pick first key from digits, and then do recursive call for each other keys till we reach the end
        for(int j=0;j<letters.length();j++){
            combinations(answer,digits,prefix+letters.charAt(j),i+1,map);
        }
    }

    public static void main(String[] args){
        String digits="23";
        System.out.println(letterCombinations(digits));
    }
}
