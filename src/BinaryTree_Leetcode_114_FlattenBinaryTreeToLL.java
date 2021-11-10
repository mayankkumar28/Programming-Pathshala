/*
In recursive approach we are building our way up
so for preorder traversal we are doing post order traversal, so we go first right, then left then root
we first go to our right most node in the right sub tree, then assign it to prev
then for next all nodes, it's right node will be prev and left node will be null till we backtrack to original root node

In morris traversal we travel till we find a node having a left child
for that left child we find the right-most node, and assign it to the right node of the curr node
we repeat this cycle till there are no left nodes and curr reaches null at the end
 */

public class BinaryTree_Leetcode_114_FlattenBinaryTreeToLL {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //====== Morris Traversal ========
    public void flattenn(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode runner = curr.left;
                while (runner.right != null) runner = runner.right;
                runner.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}