public class Leetcode_189_rotateArraybyK {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return;

        //Approach 1 using another array
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            //nums[i] = temp[i];
            System.out.print(temp[i] + " ");
        }
        System.out.println();

        //Approach 2 using same array and reversing it
        int chunk = k%n;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,chunk-1);
        reverse(nums,chunk, nums.length-1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int k =3;
        rotate(nums,k);
    }
}
