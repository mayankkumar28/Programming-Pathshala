import java.util.Scanner;

public class Maths_Codeforces_621B_SharksAndBishops {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //There are 4 diagonals :
        //Off diagonal having same positive differences, that have slope of -1: /
        int[] pov_diff = new int[1001];
        //Off diagonal having same negative differences, that have slope of +1: \
        int[] neg_diff = new int[1001];
        //Main diagonal of slope -1 / their sum is equal. We don't know the exact length so had to initialize at 2001;
        int[] sum = new int[2001];
        //Main diagonal of slope 1 \ their diff is equal
        int diagonal=0;


        while(n!=0){
            int row = sc.nextInt();
            int col = sc.nextInt();

            //Counting bishops on diagonals and storing
            if(row>col) pov_diff[row-col]++;
            else if (col>row) neg_diff[col-row]++;
            else diagonal++;
            sum[col+row]++;
            n--;
        }
        long answer = 0;

        //Diagonals having at-least 2 bishops on them. Total pairs are n*n-1 / 2
        for (int i = 1;i<1001;i++){
            if (pov_diff[i]>=2) answer += perm(pov_diff[i]);
            if (neg_diff[i]>=2) answer += perm(neg_diff[i]);
        }
        for (int i= 2;i<2001;i++){
            if (sum[i]>=2) answer+=perm(sum[i]);
        }
        if(diagonal>=2) answer+=perm(diagonal);
        System.out.println(answer);
    }

    //Function for n*n-1 /2
    public static long perm(int n){
        return (long) n*(n-1)/2;
    }
}
