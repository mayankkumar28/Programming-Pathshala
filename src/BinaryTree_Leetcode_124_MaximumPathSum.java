/*
Similar to finding diameter and checking height balanced tree
we maintain a global variable maxSum which is updated to the max sum we find while traversal
we traverse and for every node we find the sum of the left subtree and the right subtree
if we find a max sum in the process, we update it else we ignore and move on
we keep adding the node value to the sum as we backtrack (return) so that upper nodes sums can be calculated
 */

public class BinaryTree_Leetcode_124_MaximumPathSum {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        getMaxPath(root);
        return maxSum;
    }

    public int getMaxPath (TreeNode root){
        if (root == null) return 0;
        int lh = Math.max(0, getMaxPath(root.left));
        int rh = Math.max(0, getMaxPath(root.right));
        maxSum = Math.max(maxSum,lh+rh+root.val);
        return Math.max(lh,rh)+root.val;
    }
}
