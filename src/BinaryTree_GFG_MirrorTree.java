/*
check if node is null or not, if it is, return
Swap the right and left nodes recursively
 */

public class BinaryTree_GFG_MirrorTree {
    void mirror(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }
}
