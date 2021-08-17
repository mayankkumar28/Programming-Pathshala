/*
Idea is based on binary search. First we determine if the target is present or not
If present we check for the lowest and highest index
For lowest index we check if the number left is target or not. if it is target, it is not the lowest and assign that as low
To prevent index out of bounds, we first check if the position is the starting position or not
In middle we check if we have found the target by if checking ans array has changed from -1
Similarly for highest we first check if it is the last index, if not we check the index after it is target, if yes we assign that as high
 */
public class Searching_GFG_NumberOfOccurrence {
    public static int count(int[] arr, int n, int x) {
        int[] ans = {-1,-1};  //default array
        int low=0,high= arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<x) low= mid+1;
            else if (arr[mid]>x) high=mid-1;
            else {
                //checking the lowest index
                if(mid==0) {
                    ans[0]=0; //lowest target found at 0 index
                    low=0;
                    break;
                }
                else if (arr[mid-1]!=x) {
                    low=mid;
                    ans[0]=mid;  //lowest target found
                    break;
                }
                else high=mid-1; //not the lowest
            }
        }
        if (ans[0]== -1) return 0; //target not found

        //Checking the highest index
        high= n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<x) low= mid+1;
            else if (arr[mid]>x) high=mid-1;
            else {
                if (mid== arr.length-1){
                    ans[1]= arr.length-1;  //highest found at last index
                    break;
                }
                else if (arr[mid+1] != x){
                    ans[1]=mid; //highest found
                    break;
                }
                else low=mid+1; //not the highest index
            }
        }
        return ans[1]-ans[0]+1;
    }

    public static void main(String[] args){
        int[] arr = {1,1,2,2,2,2,3};
        int n = arr.length;
        int x = 2;
        System.out.println(count(arr,n,x));
    }
}
