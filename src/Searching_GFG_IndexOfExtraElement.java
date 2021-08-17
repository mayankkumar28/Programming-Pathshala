/*
If elements at same index are equal we go left, else we go right
while going right, keep checking whether we hit the extra element or not
take care of edge cases separately
 */

public class Searching_GFG_IndexOfExtraElement {
    public static int findExtra(int[] a, int[] b, int n) {
        int low = 0,high = n-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if (mid == 0){  //edge case for index 0
                if (a[mid] != b[mid]) return mid;
                else low=mid+1;
            }
            if (mid == n-1){ //edge case for index n-1
                if (a[mid] == b[mid-1]) high = mid-1;
                else return mid;
            }
            else if (a[mid] == b[mid]) {  //no extra element, go right
                low=mid+1;
            }
            else{
                if (a[mid] == b[mid-1]) high = mid-1;  //extra element go left
                else return mid; //found the element
            }
        }
        return -1;
    }
    public static void main (String[] args){
        int[] a = {1,5};
        int[] b = {1};
        int n = a.length;
        System.out.println(findExtra(a,b,n));
    }
}