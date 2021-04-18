public class Leetcode_42 {
    public static int trap(int[] height){
        int[] pmax = new int[height.length];
        int[] smax = new int[height.length];
        int amount=0;
        if (height.length==0) return 0;

        pmax[0]=height[0];
        for (int i =1; i< height.length;i++){
            pmax[i]= Math.max(pmax[i-1], height[i]);
        }

        smax[height.length-1]= height[height.length-1];
        for (int i = height.length-2;i>=0;i--){
            smax[i]=Math.max(smax[i+1],height[i]);
        }

        for (int i=1; i<height.length-1;i++){
            int min_h = Math.min(pmax[i-1],smax[i+1]);
            if (min_h> height[i]){
                amount += min_h-height[i];
            }
        }
        return amount;
    }
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
