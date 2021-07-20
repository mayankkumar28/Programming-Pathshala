
//Main idea is same as generating permutations by swapping
//We generate permutations as usual and add only those whose i%nums[i]==0 or vice versa

public class Backtracking_Leetcode_526_BeautifulArrangement {
    static int count=0;
    public static int countArrangement(int n) {
        int[] nums = new int[n+1];
        for (int i=1;i<=n;i++){
            nums[i]=i;
        }
        backtrack(nums,1);
        return count;
    }
    public static void backtrack(int[] nums,int start){
        if (start==nums.length){
            count++;
            return;
        }
        for (int i=start;i<nums.length;i++){
            swap(nums,start,i);
            if (nums[start]%start==0 || start%nums[start]==0){  //We backtrack only if the condition is fulfilled
                backtrack(nums,start+1);
            }
            swap(nums,start,i);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args){
        int n =3;
        System.out.println(countArrangement(n));
    }
}
