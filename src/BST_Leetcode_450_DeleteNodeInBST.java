/*
First we find the node we have to delete by iterating in our binary tree, keeping track of parent so that we don't loose it
if the parent itself is null, it means we have to delete the root, for which we call deleteRootNode method
so we find the node on the left side of parent, we delete the left side node or else the right side node accordingly
for deleting we can find either the max of the lst or min of the rst to maintain the structure of bst,
 */

public class BST_Leetcode_450_DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        //finding node to delete
        while (cur != null && cur.val != key) {
            parent = cur;
            if (key < cur.val) cur = cur.left;
            else if (key > cur.val) cur = cur.right;
        }
        if (parent == null) return deleteRootNode(cur);
        if (parent.left == cur) parent.left = deleteRootNode(cur);
        else parent.right = deleteRootNode(cur);
        return root;
    }

    private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) return null;
        //for bst with single side node
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        //for bst with both left and right nodes
        TreeNode next = findMax(root.left);
        next.right = root.right;
        return root.left;
    }

    private TreeNode findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
