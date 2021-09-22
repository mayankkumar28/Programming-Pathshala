import java.util.Stack;

/*
********Very Popular Stack concept *********
* to find and populate an array containing next larger element
* we use a stack instead of iterating, we keep pushing in stack if the next element is smaller than present
* when we reach an element larger, we keeping popping till the present element is still larger or stack gets empty
* we then push the greater element to the stack and move on
* at the end it is possible that for some elements we couldn't find larger element on the right
* for this we keep popping till stack get emptied and assign -1 to their ans array index\
 */

public class Stacks_GFG_NextGreaterElement {
    public static long[] nextLargerElement(long[] arr, int n){
        long[] ans = new long[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i =0;i<n;i++){
            while (!st.empty() && arr[i]>arr[st.peek()]){   //larger num found, keep popping
                ans[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.empty()){   //no larger num found
            ans[st.peek()] = -1;
            st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr  = {1,3,2,4};
        long[] temp = nextLargerElement(arr, arr.length);
        for (long i : temp) System.out.print(i+" ");
    }
}
