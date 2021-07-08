import java.util.ArrayList;

//Idea is to generate all possible strings such that two same letter are not repeated together
// Basically last character of our temp string should not be equal to char we are adding

public class Leetcode_1415_KthLexicographicalString {
    public static String getHappyString(int n, int k) {
        ArrayList<String> ans = new ArrayList<>();
        String happy = "abc";  //Given chars
        String temp="";
        backtrack(n,ans,happy,temp);
        if (ans.size()>=k){
            return ans.get(k-1); //when k combinations are present
        }
        return temp; //when less than k combinations, returns empty string

    }

    public static void backtrack(int n,ArrayList<String> ans,String happy,String temp){

        //we reach the limit of length of string
        if (n==0){
            ans.add(temp); //adding case to ans list
            return;
        }

        for (int i = 0; i<3; i++){
            if (temp.equals("") || temp.charAt(temp.length()-1) != happy.charAt(i)){  //Main algo
                backtrack(n-1,ans,happy,temp+happy.charAt(i));
            }
        }
    }

    public static void main(String[] args){
        int n =3,k=9;
        System.out.println(getHappyString(n,k));
    }
}
