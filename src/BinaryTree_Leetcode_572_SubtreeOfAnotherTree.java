//For each node during pre-order traversal of root, use a recursive function isSame to validate if sub-tree started with this node is the same with subRoot
public class BinaryTree_Leetcode_572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root,subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root ==null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
    }

}
