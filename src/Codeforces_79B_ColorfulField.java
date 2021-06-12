import java.util.Arrays;
import java.util.Scanner;

public class Codeforces_79B_ColorfulField {
    public static void main(String[] args) {
        //Taking inputs
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long m = scan.nextLong();
        long k = scan.nextLong();
        long t = scan.nextLong();

        //All indexes of matrix is defined such that they will be [1,2,3,4,5][6,7,8,9,10]....so on
        //Without waste area, answer will be index %3
        //Storing waste indexes in form of these
        long[] waste = new long[(int) k];
        for(int i =0; i<k;i++){
            int row=scan.nextInt()-1;
            int col=scan.nextInt()-1;
            waste[i]=m*(row)+(col);
        }

        //Sorting waste is imp, wasted so few hours because of it
        Arrays.sort(waste);

        //Storing other indices and cal a index, we have to offset the main indexes by no. of waste areas before them
        while(t !=0){
            int row = scan.nextInt()-1;
            int col = scan.nextInt()-1;
            long mat_num = m*(row)+(col);
            int index=0;
            for (int j =0;j<k;j++){
                if (waste[j]==mat_num) index=-1;
                else if (waste[j]<mat_num) {
                    index++;
                }
            }


            if (index==-1) {
                System.out.println("Waste");
            }

            //Offsetting no. of waste areas before the index and output is based on %3
            else {
                long adjust = mat_num - index;
                if (adjust % 3 == 0) System.out.println("Carrots");
                else if (adjust % 3 == 1) System.out.println("Kiwis");
                else System.out.println("Grapes");
            }
            t--;
        }
    }
}
