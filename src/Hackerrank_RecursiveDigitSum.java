//Failing because of TLE
//Time complexity of Int to string at last line is O(n)
//Better to use only sum and use %10 and /10 to recurse but the logic is same

public class Hackerrank_RecursiveDigitSum {

    public static void main(String[] args){
        String n = "148";
        int k = 3;
        System.out.println(superDigit(n,k));
    }

    public static int superDigit(String n,int k){
        String temp_str = "";

        //Calculating the first string with n being k times
        while (k!=0){
            temp_str +=n;
            k--;
        }
        return recurse(temp_str);
    }
    public static int recurse(String temp_str){
        int sum=0;
        //For each new string = we calculate the sum till it is less than 10
        for(int i=0;i<temp_str.length();i++){
            sum+=temp_str.charAt(i)-'0';
        }
        if(sum<10){
            return sum;
        }
        //Running again with the sum as new string
        return recurse(Integer.toString(sum));
    }
}
