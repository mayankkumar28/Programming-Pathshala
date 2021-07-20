public class Arrays_Leetcode_121_SellStock {
    public static int maxProfit(int[] prices){
        int n =prices.length;
        int profit=0;
        if (n<=1) return 0;

        //suffix max
        int[] smax = new int[n];
        smax[n-1] = prices[n-1];
        for (int i= n-2; i>=0;i--){
            smax[i]= Math.max(smax[i+1],prices[i]);
        }

        int min = Integer.MAX_VALUE;
        for (int i =0;i<n-1;i++){
            min=Math.min(min,prices[i]);
            if (min<smax[i+1]){
                profit = Math.max(profit,smax[i+1]-min);
            }
        }
        return profit;
    }
    public static void main(String[] args){
        int[] prices = {2,1,4};
        System.out.println(maxProfit(prices));
    }
}
