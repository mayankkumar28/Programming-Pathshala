/*
For each node, find the greatest height of left and right subtree
if the sum of them is greater than our current ans, we update the ans else we move on
while backtracking we return the whether left or right subtree has the longest length
it is because the node for the longest diameter can exists entirely in left or right sub-tree
 */

public class BinaryTree_Leetcode_543_DiameterOfBinaryTree {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return ans;
    }

    public int getHeight (TreeNode root){
        if (root == null) return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        ans = Math.max(ans, lh + rh);
        return 1+Math.max(lh,rh);   //returns max height of subtree
    }
}
