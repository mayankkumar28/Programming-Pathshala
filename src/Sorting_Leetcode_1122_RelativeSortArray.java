import java.util.Arrays;

public class Sorting_Leetcode_1122_RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] rank = new int[1001];   //Storing ranks of all values in array2
        Arrays.fill(rank, Integer.MAX_VALUE);
        for (int i=0;i< arr2.length;i++) rank[arr2[i]]=i;
        tuple[] nums_rank = new tuple[arr1.length];
        for (int i =0;i< arr1.length;i++){
            nums_rank[i]=new tuple(arr1[i],rank[arr1[i]]);
        }

        Arrays.sort(nums_rank, ((o1, o2) -> {
            if (o1.y != o2.y) return o1.y-o2.y;  //for sorting different ranks in ascending order
            else return o1.x-o2.x;             //for sorting nums with same ranks in asc. order
        }));

        int[] ans = new int[arr1.length];
        for (int i =0;i< arr1.length;i++) ans[i]=nums_rank[i].x;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={2,1,4,3,9,6};
        int[] temp = relativeSortArray(arr1,arr2);
        for (int i:temp) System.out.print(i +" ");
    }
}
