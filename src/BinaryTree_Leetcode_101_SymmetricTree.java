/*
We divide the tree into the left sub-tree and right sub-tree
then we check if their values are same and recursively call same function for next left and right nodes
if null, we first check if both are null, if so, we return true
else if return false, because one node null and other not will be not a mirror tree
 */

public class BinaryTree_Leetcode_101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return areMirror(root.left, root.right);
    }

    public boolean areMirror (TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && areMirror(left.left,right.right) && areMirror(left.right, right.left);
    }
}
