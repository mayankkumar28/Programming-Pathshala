/*
Similar to other merge sort questions
Using a prefix sum array to store sums and can get a sum b/w i and j index by sum[j]-sum[i]
Computing a lower index limit where all sum thereafter is greater than the lower limit
Computing a upper index limit where all sum thereafter is lower or equal to than the upper limit
 */

public class Sorting_Leetcode_327_CountOfRangeSum {
    static int count;
    static long[] temp;

    public static int countRangeSum(int[] nums, int lower, int upper) {
        count=0;
        temp = new long[nums.length+1];
        long[] sum= new long[nums.length+1];
        sum[0]=0;
        for (int i=1;i<sum.length;i++){
            sum[i]= nums[i-1]+sum[i-1];
        }
        mergesort(sum,0,sum.length-1,lower,upper);
        return count;
    }

    public static void mergesort(long[] sum,int i,int j,int lower,int upper){
        if(i==j) return;
        int mid = i+(j-i)/2;
        mergesort(sum,i,mid,lower,upper);
        mergesort(sum,mid+1,j,lower,upper);
        merge(sum,i,mid,mid+1,j,lower,upper);
    }

    public static void merge(long[] sum,int s1,int e1,int s2,int e2,int lower,int upper){
        int startIndex = s2, endIndex = s2;
        for (int l =s1;l<=e1;l++){
            while(startIndex<=e2 && sum[startIndex]-sum[l] < lower) {
                startIndex++;
            }
            while (endIndex<=e2 && sum[endIndex]-sum[l] <= upper){
                endIndex++;
            }
            count += endIndex-startIndex;
        }

        //Usual merge sort logic
        int i =s1,j=s2,c=s1;
        while(i<=e1 && j<=e2){
            if (sum[i] <= sum[j]) temp[c++] = sum[i++];
            else temp[c++] = sum[j++];
        }
        while (i<=e1) temp[c++] = sum[i++];
        while (j<=e2) temp[c++] = sum[j++];
        for (int x = s1; x<=e2; x++) sum[x] = temp[x];
    }

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        int lower = -2, upper = 2;
        System.out.println(countRangeSum(nums,lower,upper));
    }
}
