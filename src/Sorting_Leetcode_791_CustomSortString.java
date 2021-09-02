/*
we maintain an array rank to check the ranking of each char in order string based on occurrence
we created a tuple of char and ranking, and sort them on basis of ranking
we print the string
 */

import java.util.Arrays;

class pair1{
    char character;
    int rank;
    public pair1(char character,int rank){
        this.character=character;
        this.rank=rank;
    }
}

public class Sorting_Leetcode_791_CustomSortString {
    public static String customSortString(String order, String s) {
        int[] rank =new int[26];
        for (int i =0;i<26;i++){
            rank[i]=Integer.MAX_VALUE;
        }
        for (int i =0;i<order.length();i++){
            rank[order.charAt(i)-'a']=i;   //assigning ranks of each char in order
        }

        pair1[] check = new pair1[s.length()];
        for (int i =0;i<s.length();i++){
            check[i]=new pair1(s.charAt(i),rank[s.charAt(i)-'a']);  //combining rank and char of string s
        }
        Arrays.sort(check, (o1, o2) -> {    //used lambda function for sorting
            if (o1.rank!=o2.rank) return o1.rank-o2.rank;
            return 0;
        });

        StringBuilder ans= new StringBuilder();
        for (pair1 pair1 : check) {
            ans.append(pair1.character);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String order= "cba", s = "abcd";
        System.out.println(customSortString(order,s));
    }
}

