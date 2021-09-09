//Area can be maximized by index diff and min. height of the two, so start from max index diff, and inc. lower height

public class TwoPointer_Leetcode_11_ContainerMostWater {
    public static int maxArea(int[] height) {
        int n = height.length;
        int low =0, high= n-1;
        int area = 0; int ans = -1;
        while(low<high){
            int lower_h = Math.min(height[low],height[high]);
            area = (high-low)*(lower_h);
            ans = Math.max(ans,area);

            if (height[low] <= height[high]) low++;
            else high--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
