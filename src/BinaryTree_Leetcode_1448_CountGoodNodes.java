/*
take root and root.val as reference point
if  node val is greater than or equal to curr max val, if count ++ and recurse for the left and right nodes, updating our curr max
 */

public class BinaryTree_Leetcode_1448_CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return countNodes(root,root.val);
    }

    public int countNodes(TreeNode node,int curr_max){
        if (node == null) return 0;
        int count = node.val >= curr_max ? 1:0;
        count += countNodes(node.left, Math.max(curr_max, node.val));
        count += countNodes(node.right,Math.max(curr_max, node.val));
        return count;
    }
}
