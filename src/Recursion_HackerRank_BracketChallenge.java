
//Not Working

import java.util.Scanner;

public class Recursion_HackerRank_BracketChallenge {
    public static void printall(String a,int n,int m, int op1,int cl1,int op2,int cl2){
        if(a.length()-1 == 2*(n+m)){
            a=a.replace(" ","");
            System.out.println(a);
            return ;
        }
        if(op1 <= n  ){

            if(op1 == cl1 && op1 < n)
                printall(a + "(",n,m,op1+1,cl1,op2,cl2);
            else if(op1 < n)
                printall(a + "(",n,m,op1+1,cl1,op2,cl2);

            if(cl1 < op1 &&(a.charAt(a.length()-1)!= '{') )
                printall(a +")",n,m,op1,cl1+1,op2,cl2);
        }

        if(op2 <= m ){
            if(op2 == cl2 && op2 < m)
                printall(a + "{",n,m,op1,cl1,op2+1,cl2);
            else if(op2 < m)
                printall(a + "{",n,m,op1,cl1,op2+1,cl2);

            if(cl2 < op2 &&(a.charAt(a.length()-1)!= '(') )
                printall(a +"}",n,m,op1,cl1,op2,cl2+1);
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        printall(" ",n,m,0,0,0,0);
    }
}



