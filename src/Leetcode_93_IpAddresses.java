import java.util.ArrayList;
import java.util.List;

//This condition is that the integer should be between 0 to 255 and shouldn't start with 0 if >0
//So we can use backtracking and check each char in String one by one
//We start from first digit,backtrack, then if next one can be a 2 digit without starting with 0,backtrack
//Then if next one can be 3 digit less than 255,backtrack
//Backtracking till we reach index =4 or end of the string
//We add to answer only if and it is end of the string.

public class Leetcode_93_IpAddresses {
    public static List<String> restoreIpAddresses(String s){
        List<String> ans = new ArrayList<>();

        if (s.length()<4 || s.length()>12){   //For string to be valid
            return ans;
        }
        dfs(s,"",ans,0);
        return ans;
    }

    public static void dfs(String s,String sub, List<String> ans, int index){
        if (index ==4 || s.length()==0){
            if (index ==4 && s.length()==0){
                ans.add(sub.substring(0,sub.length()-1)); //Adding ans, removing last dot
                //System.out.println("Yes " +sub);
                return;
            }
            //System.out.println("No " +sub);
            return;
        }
        dfs(s.substring(1),sub+s.charAt(0)+".",ans,index+1); //First digit

        if (s.length()>1 && s.charAt(0)!='0') {
            dfs(s.substring(2), sub + s.substring(0, 2) + ".", ans, index + 1); //Second digit

            if (s.length() > 2 && Integer.parseInt(s.substring(0, 3)) <= 255) {
                dfs(s.substring(3), sub + s.substring(0, 3) + ".", ans, index + 1); //Third digit
            }
        }
    }


    public static void main(String[] args){
        String s ="25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
