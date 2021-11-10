//first we check the given roots if equal or not including null, then check recursively the left and right nodes

public class BinaryTree_Leetcode_100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p== null || q == null) return p==q;
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
