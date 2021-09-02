import java.util.Arrays;

public class Sorting_Leetcode_179_LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] s_nums = new String[nums.length];
        for (int i =0;i< nums.length;i++){
            s_nums[i]= String.valueOf(nums[i]);  //converting int to string
        }
        Arrays.sort(s_nums, (s1,s2) -> {
            String str1 = s1+s2;
            String str2 = s2+s1;
            return str2.compareTo(str1); //Sorting in descending order so that we can append easily later
        });
        if (s_nums[0].charAt(0)=='0') return "0";  //If all nums are zero, return just 0
        StringBuilder sb = new StringBuilder();
        for (String s : s_nums) sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
