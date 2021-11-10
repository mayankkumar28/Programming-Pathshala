/*
We store all sum with their freq in the a map while iterating and calculating sum in the tree recursively
we also maintain a int with max freq encountered till now
then we iterate through the map and search for the max freq key, and add all all the values of it to our ans array
 */

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTree_Leetcode_508_MostFrequentSubtreeSum {
    HashMap<Integer,Integer> map = new HashMap<>();
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : map.keySet()){
            if (map.get(i) == maxFreq) ans.add(i);
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    public int getSum(TreeNode root){
        if (root == null ) return 0;
        int lh = getSum(root.left);
        int rh = getSum(root.right);
        int sum = lh + rh + root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        maxFreq = Math.max(maxFreq,map.get(sum));
        return sum;
    }
}
