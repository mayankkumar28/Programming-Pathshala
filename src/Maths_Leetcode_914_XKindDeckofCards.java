public class Maths_Leetcode_914_XKindDeckofCards {
    public static boolean hasGroupsSizeX(int[] deck){
        int n = deck.length;
        if (n<2) return false;
        int[] c_arr = new int[10000];
        int ans = 0;
        for (int i =0;i<n;i++){
            c_arr[deck[i]]++;
        }
        for (int i =0;i<n;i++){
            ans= gcd(ans,c_arr[i]);
        }
        return ans > 1;
    }
    public static void main(String[] args){
        int[] deck = {1,1,1};
        System.out.println(hasGroupsSizeX(deck));
    }
    public static int gcd(int a,int b){
        int maxm=Math.max(a,b);
        int minm=Math.min(a,b);
        if (minm==0) return maxm;
        while(maxm%minm!=0){
            int temp=maxm;
            maxm=minm;
            minm=temp%minm;
        }
        return minm;
    }
}
