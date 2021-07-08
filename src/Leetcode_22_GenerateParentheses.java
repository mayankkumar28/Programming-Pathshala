import java.util.ArrayList;
import java.util.List;

//Idea is that number of right bracket can't be greater than left bracket at any time
//We use l and r to maintain counts of left and right brackets which will never be greater than n
//We do recursive calls to find all permutations starting with left bracket till l and r reach n

public class Leetcode_22_GenerateParentheses {
    public static List<String> generateParenthesis(int n){
        List<String> answer = new ArrayList<>();
        balance(n,0,0,answer,"");
        return answer;
    }

    public static void balance (int n,int l,int r,List<String> answer, String temp){
//        =======Method 1 ============
//        if (l==n && r==n){
//            answer.add(temp);
//            return;
//        }
//        if (l<n){
//            balance(n,l+1,r,answer,temp+"(");
//        }
//        if (r<l){
//            balance(n,l,r+1,answer,temp+")");
//        }

//        ==========Method 2 ==========
        if (l==n && r==n){
            answer.add(temp);
            return;
        }
        if (l==r){
            temp+= "(";
            balance(n,l+1,r,answer,temp);
        }
        else if (l>r){
            if(l==n){
                temp+=")";
                balance(n,l,r+1,answer,temp);
            }
            else{
                //temp+="(";
                balance(n,l+1,r,answer,temp+"(");
                //temp+=")";
                balance(n,l,r+1,answer,temp+")");
            }
        }
    }

    public static void main(String[] args){
        int n =3;
        System.out.println(generateParenthesis(n));
    }
}

//


