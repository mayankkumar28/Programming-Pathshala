import java.util.Scanner;

public class Codeforces_152C_PocketBook {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long mod = 1000000007;

        //Using toCharArray to make a 2D Char array to store inputs.
        char[][] arr = new char[n][];
        for (int i =0;i<n;i++){
            arr[i]=sc.next().toCharArray();
        }

        long ans=1;
        //Iterating downwards in char matrix and looking for duplicate char by using bool array.
        //Answer will be product of number of distinct chars in each col

        for (int i =0;i<m;i++){
            int counter=0;
            boolean[] count =new boolean[26];
            for(int j=0;j<n;j++){
                int index = arr[j][i]-'A';
                if (!count[index]) {
                    count[index]=true;
                    counter++;
                }
            }
            ans = ((ans%mod) * (counter%mod)%mod);
        }
        System.out.println(ans);
    }
}
