/*
maintain a boolean isleft which indicates whether the present node is the left one or not
if it is left one and both left and right are null, then it is the last left leaf and we return it's value
 */

public class BinaryTree_Leetcode_404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return countLeft(root,false);
    }

    public int countLeft(TreeNode root,boolean isLeft){
        if (root == null) return 0;
        else if (root.left == null && root.right == null && isLeft){
            return root.val;
        }
        return countLeft(root.left,true) + countLeft(root.right,false);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { }
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
