public class Arrays_Leetcode_565_ArrayNesting {
    public static int arrayNesting(int[] nums) {
        int n = nums.length;
        if (n<=1) return 1;
        int ans = 0;
        for (int i=0;i<n;i++){
            int count =1;
            if (nums[i]>=0){
                int index = nums[i];
                int val = i;
                while (index!=i){
                    int temp = nums[index];
                    nums[index]= -1*(val+1);
                    val= index;
                    index=temp;
                    count++;
                    //System.out.println(count);
                }
                nums[index]= -1*(val+1);
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={5,4,0,3,1,6,2};
        //int[] nums={0};
        System.out.println(arrayNesting(nums));
    }
}
