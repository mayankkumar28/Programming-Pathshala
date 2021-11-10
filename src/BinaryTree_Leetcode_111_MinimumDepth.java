/*
here normal recursion for left and right and adding 1 each time for a level won't work because min of null will always be null
So here instead of retuning null, we return the highest int value instead, which compensates it
Then we recurse for left and right values, and add 1 to each level we recurse.
 */


public class BinaryTree_Leetcode_111_MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null ) return 0;
        return minHeight(root);
    }

    public int minHeight(TreeNode node){
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return 1;  //reached leaf
        int lh = minHeight(node.left);
        int rh = minHeight(node.right);
        return 1+Math.min(lh,rh);
    }
}
