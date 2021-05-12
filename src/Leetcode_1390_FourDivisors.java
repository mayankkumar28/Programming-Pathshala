public class Leetcode_1390_FourDivisors {
    public static int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum=0;
        int count=0;
        int answer=0;
        for (int i =0;i<n;i++){
            sum=0;
            count=0;
            for (int j =1;j<=Math.sqrt(nums[i]);j++){
                if (nums[i]%j==0){
                    if (j*j==nums[i]){sum += j;count++;}
                    else {sum+= j+(nums[i]/j); count+=2;}
                }
            }
            if (count==4) answer+=sum;
        }
        return answer;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(sumFourDivisors(nums));
    }
}
