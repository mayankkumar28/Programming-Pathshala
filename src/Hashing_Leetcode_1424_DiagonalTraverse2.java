import java.util.*;

/*
Altered version of Leetcode 498 Diagonal Traversal 1
Here we notice that minor diagonals indexes always have equal sums,
so we use a map with sum of index as key, and values of all the diagonals having that sum in a list
if elements in the diagonal always start from bottom, we start from the lowest row of the matrix, and iterate till no. of cols in that row
we store all nums having according to the key sum and copy them to the answer array
we use max_sum to determine max sum possible and elements to determine no. of elements present
 */

public class Hashing_Leetcode_1424_DiagonalTraverse2 {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        if (n==0) return new int[0];  //edge case test
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int max_sum =0;
        int elements =0;
        for (int r = n-1;r>=0;r--){  //starting from bottom row to top
            for (int c =0; c<nums.get(r).size();c++){  //starting from lowest col to highest
                int sum = r+c;
                ArrayList<Integer> list = map.getOrDefault(sum,new ArrayList<>());
                list.add(nums.get(r).get(c));
                map.put(sum,list);
                max_sum = Math.max(max_sum,sum);
                elements++;
            }
        }

        int[] ans = new int[elements];
        int counter =0;
        for (int i =0;i<=max_sum;i++){
            if (map.containsKey(i)){
                ArrayList<Integer> temp =  map.get(i);
                for (int j : temp) ans[counter++] = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        nums.add(new ArrayList<>(Arrays.asList(6,7)));
        nums.add(new ArrayList<>(Arrays.asList(8)));
        nums.add(new ArrayList<>(Arrays.asList(9,10,11)));
        nums.add(new ArrayList<>(Arrays.asList(12,13,14,15,16)));
        int[] temp = findDiagonalOrder(nums);
        for (int i :temp ) System.out.print(i +" ");
    }
}
