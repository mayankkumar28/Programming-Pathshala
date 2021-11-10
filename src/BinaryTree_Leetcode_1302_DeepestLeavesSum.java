/*
Doing dfs, using global variables - sum and deepest to keep count of the deepest node and the current sum
we will initially set depth, deepest and sum all to zero, and then do recursion
if we are at a leaf, we determine if it the deepest one, if it is, we add it's value to the sum
if it is not, we make it our deepest, and make it's value our current sum
 */

public class BinaryTree_Leetcode_1302_DeepestLeavesSum {
    int deepest = 0, sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        return deepSum(root, 0);
    }

    public int deepSum(TreeNode node, int depth) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            if (depth == deepest) sum += node.val;
            else if (depth > deepest) {
                sum = node.val;
                deepest = depth;
            }
        }
        deepSum(node.left, depth + 1);
        deepSum(node.right, depth + 1);
        return sum;
    }
}
