public class Maths_Leetcode_1250_GoodArray {
    public static boolean isGoodArray(int[] nums) {
        int n =nums.length;
        if (n==1 && nums[0]==1) return true;
        int gcd=nums[0];
        for(int i =1;i<n;i++){
            gcd=gcd(gcd,nums[i]);
            System.out.println(gcd +" " +nums[i]);
            if (gcd==1) return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] nums={6,10,15};
        System.out.println(isGoodArray(nums));

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
