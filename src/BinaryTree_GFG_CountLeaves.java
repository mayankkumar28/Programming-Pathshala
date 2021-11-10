/*
Simply check if null, then return (zero)
if at a non null node, left and right are both null, return 1
start recursion from root
 */

public class BinaryTree_GFG_CountLeaves {
    int countLeaves(Node node){
        if (node == null) return 0;
        if (node.left == null && node.right== null) return 1;
        return countLeaves(node.left)+countLeaves(node.right);
    }

    class Node {
        int data;
        Node left, right;
    }
}


