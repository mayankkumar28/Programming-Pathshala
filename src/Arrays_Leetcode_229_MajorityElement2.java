import java.util.ArrayList;
import java.util.List;

public class Arrays_Leetcode_229_MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int majority = n/3;
        int count1 =1,count2=0;
        int index1=0, index2=0;
        for (int i=1;i<n;i++){
            if (nums[index1]==nums[i]){
                count1++;
            }
            else if (nums[index2]==nums[i]){
                count2++;
            }
            else if (count1==0){
                count1=1;
                index1=i;
            }
            else if (count2==0){
                count2=1;
                index2=i;
            }
            else {count1--;count2--;}
            System.out.println(nums[index1] +"," +count1+"," +nums[index2] +","+count2);
        }

        count1=0;count2=0;
        for (int i=0;i<n;i++){
            if (nums[index1]==nums[i]){
                count1++;
            }
            if (nums[index2]==nums[i]){
                count2++;
            }
        }
        if (count1>majority) ans.add(nums[index1]);
        if (count2>majority) ans.add(nums[index2]);
        return ans;
    }
    public static void main(String[] args){
        int[] nums={1};
        System.out.println(majorityElement(nums));
    }

}
