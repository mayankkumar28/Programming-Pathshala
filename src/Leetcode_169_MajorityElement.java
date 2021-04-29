public class Leetcode_169_MajorityElement {
    public static int majorityElement(int[] nums){
//        int n = nums.length;
//        int majority = n/2;
//        if (n%2==0) majority++;
        int count =1;
        int index =0;
        for (int i=1;i< nums.length;i++){
            if (nums[i]==nums[index]) count++;
            else count--;
            if (count==0) {
                index=i;
                count=1;
            }
        }
        return nums[index];

//        Checking if majority element really exits, In Question it's given it always exists so no need
//        count=0;
//        for (int i =0;i<n;i++){
//            if (nums[index]==nums[i]) count++;
//            if (count>=majority) return nums[index];
//        }
//        return 0;

        //========= 0(N2) Time Approach============
//        for(int i =0; i<n; i++){
//            int count=1;
//            for (int j=i+1;j<n;j++){
//                if (nums[i]==nums[j]) count++;
//            }
//            if (count>majority) return nums[i];
//        }
//        return 0;
    }

    public static void main(String[] args){
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
