/*
This is code for full binary tree where every node has 0 or 2 children
in class we constructed every possible binary tree, also a faster method is also possible
In this for every node, and generate all possible nodes recursively on the left and right side,and do combinations of them
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_Leetcode_894_AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
        if(n <= 0 || n % 2 == 0) return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        if (n==1){
            ans.add(new TreeNode(0));
            return ans;
        }

        for (int i =1;i<n;i+=2){
            List<TreeNode> lst = allPossibleFBT(i);
            List<TreeNode> rst = allPossibleFBT(n-1-i);
            for (TreeNode j : lst) {
                for (TreeNode k : rst) {
                    ans.add(new TreeNode(0, j, k));
                }
            }
        }
        return ans;
    }
}
