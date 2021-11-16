/*
LCA will occur when one value lies in left side and other lies in the right side
edge case will be both lying on one side, in which we return the first node found as lca
move left or right depending whether current node has values lesser or more than both the given nodes
 */

public class BST_Leetcode_235_LCAOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        int maxm = Math.max(p.val,q.val);
        int minm = Math.min(p.val,q.val);
        if (root.val > minm && root.val < maxm) return root;
        if (root.val < minm && root.val < maxm) return lowestCommonAncestor(root.right,p,q);
        else return lowestCommonAncestor(root.left,p,q);
    }
}
