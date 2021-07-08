public class Leetcode_50_PowRecursion {
    public static double myPow(double x, int n) {
        //Idea is based on x^n = x^(n/2)+x^(n/2)

        if (n==0) return 1; //For power zero we return 1
        double ans = myPow(x,n/2); //recurse till n==0
        if (n<0) x=1/x; //Dealing with negative powers
        if(n%2==0){
            return ans*ans; //for even power
        }
        return ans*ans*x; //for odd power, Ex. for 3^3 int n/2 =3/2 = 1.5 = 1
    }

    public static void main(String[] args){
        double x =2;
        int n =-3;
        System.out.println(myPow(x,n));
    }
}
