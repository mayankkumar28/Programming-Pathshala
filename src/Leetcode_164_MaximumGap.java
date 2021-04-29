public class Leetcode_164_MaximumGap {
    public static int maximumGap(int[] nums) {
        int n = nums.length;
        if (n<2) return 0;
        int MaxNum = Integer.MIN_VALUE;
        int MinNum = Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            MaxNum=Math.max(MaxNum,nums[i]);
            MinNum=Math.min(MinNum,nums[i]);
        }
        if (MaxNum-MinNum==0) return 0;
        int Gap = (MaxNum-MinNum)/(n-1);
        if ((MaxNum-MinNum)%(n-1) != 0) Gap++;
        int[] minarray = new int[n];
        int[] maxarray = new int[n];

        for(int i=0;i<n;i++){
            maxarray[i]=Integer.MIN_VALUE;
            minarray[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            int bucket= (nums[i]-MinNum)/Gap;
            maxarray[bucket]=Math.max(maxarray[bucket],nums[i]);
            minarray[bucket]=Math.min(minarray[bucket],nums[i]);
        }
        int ans=Integer.MIN_VALUE;
        int prev=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if (minarray[i]==Integer.MAX_VALUE) continue;
            if (prev==Integer.MIN_VALUE) prev=maxarray[i];
            else ans=Math.max(ans,minarray[i]-prev);
            prev = maxarray[i];
        }
        return ans;

    }
    public static void main(String[] args){
        int[] nums = {3,6,9,1};
        System.out.println(maximumGap(nums));
    }
}
