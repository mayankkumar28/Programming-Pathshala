/*
Logic is easy but a bit difficult to implement
First we count all the 1 in each row of the matrix using binary search, it is sorted in rev order so approach is different
We store all the counts in an array soldiers. We have to return indexes of the k lowest rows now
For this we use a for loop and search for a min value. we store it's index in an ans array and change it's value to maximum
We run this loop k times to find the next k minimum indexes
 */

public class Searching_Leetcode_1337_WeakestRowInMatrix {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiers = new int[mat.length];
        for (int i =0;i<mat.length;i++){
            soldiers[i]=binarySearch(mat[i]);  //storing soldiers count
        }

        int[] ans =new int[k];
        int count=0;
        while(count<k){
            int minIndex=0;
            for(int i =0;i<soldiers.length;i++){  //searching for min value index
                if (soldiers[i]<soldiers[minIndex]){
                    minIndex=i;
                }
            }
            ans[count]=minIndex;   //storing the min value index
            soldiers[minIndex]=Integer.MAX_VALUE;  //marking it's value as max so that next min can be found
            count++;
        }
        return ans;
    }

    public static int binarySearch(int[] arr){
        int low =0,high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if (arr[mid]!=1) high=mid-1;
            else low=mid+1;  //else the loop will be struck if low==mid
        }
        if (arr[low]==1) return low+1;   //try on paper for different cases, low can end on both on 0 and 1
        else return low;
    }

    public static void main(String[] args){
        int[][] mat =   {{1,1,0,0,0},
                         {1,1,1,1,0},
                         {1,0,0,0,0},
                         {1,1,0,0,0},
                         {1,1,1,1,1}};
        int k =3;
        int[] temp= kWeakestRows(mat,k);
        for(int t:temp) System.out.print(t +" ");
    }
}
