import java.util.Scanner;

public class Codeforces_740B_AlyonaFlowers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i]= sc.nextInt();
            sum[i] = arr[i]+sum[i-1];
        }

        int max = 0;
        for (int i =1; i<=m;i++){
            int left =sc.nextInt();
            int right =sc.nextInt();
            int temp =0;
            temp = sum[right]-sum[left-1];
            if (temp>0){
                max += temp;
            }
        }
        System.out.println(max);
    }
}
