public class Leetcode_123 {
    public static int maxProfit(int[] prices){
        int n =prices.length;
        if (n<=1) return 0;

        //prefix profit
        int pmin = prices[0];
        int[] pre_profit = new int[n];
        pre_profit[0]=0;
        for (int i =1;i<n;i++){
            pmin = Math.min(pmin,prices[i]);
            pre_profit[i]= Math.max(pre_profit[i-1],prices[i]-pmin);
        }

        //suffix profit
        int smax = prices[n-1];
        int[] suf_profit = new int[n];
        for (int i= n-2; i>=0;i--){
            smax= Math.max(smax,prices[i]);
            suf_profit[i]= Math.max(suf_profit[i+1],smax-prices[i]);
        }

        //finding balance
        int profit = suf_profit[0];
        for (int i=1;i<n;i++){
            profit = Math.max(profit,pre_profit[i-1]+suf_profit[i]);
        }

        //Printing arrays
        for (int i=0;i<n;i++){System.out.print(pre_profit[i] + " "); } System.out.println();
        for (int i=0;i<n;i++){System.out.print(suf_profit[i] + " "); } System.out.println();

        return profit;
    }
    public static void main(String[] args){
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}

