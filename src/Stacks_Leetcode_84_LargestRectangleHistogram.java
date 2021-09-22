import java.util.Stack;
/*
based on finding next greatest element using stack
first we find the next smallest element which will restrict our area, for all elements
then we find the previous smallest element, for all the elements
now difference b/w these two indexes will be range in which our range will occur for a particular i
to maximize, we multiply by the height of the index and take the max resulting from all elements
 */

public class Stacks_Leetcode_84_LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        //next smallest element
        st.push(0);
        for (int i =1;i<n;i++){
            while (!st.empty() && heights[i]<heights[st.peek()]){
                nse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()){
            nse[st.peek()] = n;
            st.pop();
        }

        //previous smallest element
        st.push(n-1);
        for (int i =n-2;i>=0;i--){
            while (!st.empty() && heights[i]<heights[st.peek()]){
                pse[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()){
            pse[st.peek()] = -1;
            st.pop();
        }

        //Main logic
        int maxArea = Integer.MIN_VALUE;
        for (int i =0;i<n;i++){
            maxArea = Math.max(maxArea,heights[i]*(nse[i]-pse[i]-1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
