//Recursively iterate left sub-tree and right sub-tree to find the max height, adding 1 for each level of recursion

public class BinaryTree_Leetcode_104_MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1+Math.max(lh,rh);
    }
}
