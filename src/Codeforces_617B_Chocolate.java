import java.util.Scanner;

public class Codeforces_617B_Chocolate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr= new int[n];
        long ans=0; int j=0;int count=0;
        for (int i =0;i<n;i++){
            arr[i]= sc.nextInt();
            if(arr[i]==1){
                count++;
                if (count==1) ans=1;
                else ans*= i-j;
                System.out.println("i= "+i +" j= " +j +" ans= " +ans );
                j=i;

            }
        }
        System.out.println(ans);
    }
}
