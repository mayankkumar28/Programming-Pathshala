

//Incomplete

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Recursion_Codeforces_55B_SmallestNumber {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Long> int_arr = new ArrayList<>(4);
        ArrayList<Long> answer = new ArrayList<>();
        for (int i =0;i<4;i++){
            int_arr.add(scan.nextLong());
        }
        char[] char_arr = new char[3];
        for (int i =0;i<3;i++){
            char_arr[i]= scan.next().charAt(0);
        }
        loop(char_arr,int_arr,0,answer,0,int_arr);
        Collections.sort(answer);
        System.out.println(" answer = " +answer.get(0));
    }

    public static void loop(char[] char_arr, ArrayList<Long> int_arr, long temp_ans,ArrayList<Long> answer,int index, ArrayList<Long> temp_arr){
        if (temp_arr.size()==1){
            answer.add(temp_ans);
            System.out.println("adding ans = " +temp_ans);
            return;
        }
        for (int i=0;i<temp_arr.size();i++){
            for (int j =i+1;i<temp_arr.size();i++){
                long temp1= temp_arr.get(i);
                long temp2= temp_arr.get(j);
                System.out.println("temp1 = " +temp1 +" temp2 =" +temp2);

                if(char_arr[index]=='*'){
                    temp_ans = temp1*temp2;
                }
                else temp_ans = temp1+temp2;
                System.out.println("temp_ans = " +temp_ans);
                temp_arr.set(i,temp_ans);
                temp_arr.set(j,temp_ans);
                temp_arr.remove(temp_ans);

                System.out.println();
                for (long m:temp_arr) System.out.print(m +" ");
                System.out.println("after ");

                loop(char_arr,int_arr,temp_ans,answer,index+1,temp_arr);

                temp_arr.add(temp2);
                temp_arr.set(i,temp1);

                for (long m:temp_arr) System.out.print(m +" ");
                System.out.println("before ");
            }
        }
    }
}
