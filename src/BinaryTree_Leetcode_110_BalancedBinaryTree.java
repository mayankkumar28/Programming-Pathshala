/*
Code is almost same as diameter of a tree
For every node, we determine the heights of left and right sub-tree and check whether their diff is more than 1
if diff is more than 1 for any node, it can't be balanced
so we maintain a global variable ans set to true, and return that
 */

public class BinaryTree_Leetcode_110_BalancedBinaryTree {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        getHt(root);
        return ans;
    }

    public int getHt (TreeNode root){
        if (root == null ) return 0;
        int lh = getHt(root.left);
        int rh = getHt(root.right);
        if (Math.abs(lh-rh)>1) ans = false;
        return 1 + Math.max(lh,rh);
    }
}
