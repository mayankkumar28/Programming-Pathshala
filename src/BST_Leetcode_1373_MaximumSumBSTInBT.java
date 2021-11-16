/*
using a separate class to check the max and min values, whether is it bst from bottom to top and current sum of nodes
we first traverse till the null on the both ends, and return + & - infinities as max and min values
then we check whether the current bst node is legit or not, by checking lst max and rst min values, and both are bst or not
if it is, we add to sum,calculate new max and min including this node and pass it on to the parent node
 */

public class BST_Leetcode_1373_MaximumSumBSTInBT {
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        getLargestBST(root);
        return ans;
    }

    private subTree getLargestBST(TreeNode root){
        if (root == null) return new subTree(true, Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        subTree lst = getLargestBST(root.left);
        subTree rst = getLargestBST(root.right);
        boolean isBST = false;
        int sum = root.val+lst.sum+ rst.sum;
        if (lst.isBST && rst.isBST && root.val>lst.maxm && root.val<rst.minm){
            ans = Math.max(ans, sum);
            isBST = true;
        }
        int minm = Math.min( root.val,Math.min(lst.minm,rst.minm));
        int maxm = Math.max( root.val,Math.max(lst.maxm,rst.maxm));

        return new subTree(isBST,minm,maxm,sum);
    }

    private class subTree {
        boolean isBST;
        int minm;
        int maxm;
        int sum;
        subTree(boolean isBST,int minm,int maxm,int sum){
            this.isBST = isBST;
            this.minm = minm;
            this.maxm =maxm;
            this.sum =sum;
        }
    }
}
