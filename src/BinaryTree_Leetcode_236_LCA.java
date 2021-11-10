//dfs and return either node if found, if not return null, lca will be when both lst and rst are not null

public class BinaryTree_Leetcode_236_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode lst = lowestCommonAncestor(root.left,p,q);
        TreeNode rst = lowestCommonAncestor(root.right,p,q);
        if (lst == null) return rst;
        if (rst == null) return lst;
        return root;
    }
}
