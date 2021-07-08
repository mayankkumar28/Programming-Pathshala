import java.util.ArrayList;
import java.util.Scanner;

//The idea is to start from checking b. If it is even then /2, if it has last digit =1 then remove 1
//Recurse this until b becomes less than a or b becomes equal to a
//If b hit a odd number mid-way without last digit as 1, there is no way it would reach a, so NO

public class Codeforces_727A_TransformAtoB{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        //For storing b and printing in reverse order
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(b);
        if (func1(a,b,answer)){
            System.out.println("YES");
            System.out.println(answer.size());
            for (int i= answer.size()-1;i>=0;i--){
                System.out.print(answer.get(i) +" ");
            }
        }
        else System.out.print("NO");
    }

    public static boolean func1(int a, int b,ArrayList<Integer> answer){
        if (a==b){
            return true;
        }
        if (b<a){
            return false;
        }
        if(b%10==1){        // last digit is 1
            b=b/10;
            answer.add(b);
        }
        else if (b%2==0) {  //Even number
            b=b/2;
            answer.add(b);
        }
        else return false;  //Mid-way odd number condition
        return func1(a,b,answer);
    }
}
