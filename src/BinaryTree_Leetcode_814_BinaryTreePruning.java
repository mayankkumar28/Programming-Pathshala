/*
We only have to take out the node if it is the last node and it's value is zero
so we simply do dfs till the end, if if the leaf is 0, we return zero and remove that node
 */

public class BinaryTree_Leetcode_814_BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
