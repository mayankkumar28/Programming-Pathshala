//Traverse in bst till we reach null, keep track of parent node and add accordingly to the left or right

public class BST_Leetcode_701_InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val,null,null);
        TreeNode head = root;
        TreeNode parent=null;
        while (root != null){
            parent = root;
            if (val > root.val) root = root.right;
            else root = root.left;
        }
        if (val > parent.val) parent.right = new TreeNode(val,null,null);
        else parent.left = new TreeNode(val,null,null);
        return head;
    }
}
