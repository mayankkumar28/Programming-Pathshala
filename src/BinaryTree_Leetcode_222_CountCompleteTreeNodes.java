/*
Use a separate is prefect function to determine whether the root is a perfect binary tree or not
if yes, total nodes will be 2^h-1 where h is height of the tree
if no, then we shift the root to the right node, and recurse, which will be similar to binary search in the right node
we maintain count to count number of nodes as we progress
 */

public class BinaryTree_Leetcode_222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        pair left = isPerfect(root.left);
        pair right = isPerfect(root.right);
        if (left.isSame) count += Math.pow(2, left.height)-1;
        else count += countNodes(root.left);
        if (right.isSame) count += Math.pow(2, right.height)-1;
        else count += countNodes(root.right);
        return count;
    }

    public pair isPerfect (TreeNode root){
        TreeNode temp = root;
        int h_left = 0;
        while (temp != null){
            h_left++;
            temp = temp.left;
        }
        temp = root;
        int h_right = 0;
        while (temp != null){
            h_right++;
            temp = temp.right;
        }
        return new pair(h_left == h_right,h_left);
    }

    private static class pair{
        boolean isSame;
        int height;
        pair(boolean isSame,int height){
            this.isSame = isSame;
            this.height = height;
        }
    }
}
