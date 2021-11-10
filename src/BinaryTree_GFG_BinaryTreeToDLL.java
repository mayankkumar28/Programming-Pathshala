/*
We maintain a head and a tail while we recurse through the tree
we have to do in-order traversal so first we find the leftmost node and declare it the head and tail
then the control passes to the node before it, so we double link the node with our tail node
then we search for the right node and attach it to our prev
 */

public class BinaryTree_GFG_BinaryTreeToDLL {
    TreeNode head;
    TreeNode prev;
    TreeNode bToDLL (TreeNode root){
        if (root == null) return null;
        bToDLL(root.left);
        if (prev == null){   //leftmost node, declare head
            head = root;
            prev = root;
        }
        else {
            root.left = prev;
            prev.right = root;
            prev = root;
        }
        bToDLL(root.right);
        return head;
    }
}
