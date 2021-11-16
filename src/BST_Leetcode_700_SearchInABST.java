//In bst, left side contains smaller values than root and right side contains larger, so we can iterate till we find

public class BST_Leetcode_700_SearchInABST {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if (root.val > val) root = root.left;
            else if (root.val < val) root = root.right;
            else break;  //found value
        }
        return root;
    }
}
