/*
using a separate class to check the max and min values, whether is it bst from bottom to top and current count of nodes
we first traverse till the null on the both ends, and return + & - infinities as max and min values
then we check whether the current bst node is legit or not, by checking lst max and rst min values, and both are bst or not
if it is, we inc. count,calculate new max and min including this node and pass it on to the parent node
 */

public class BST_GFG_LargestBST {
    int ans = 0;
    public int largestBst(TreeNode root){
        getLargestBST(root);
        return ans;
    }

    private subTree getLargestBST(TreeNode root){
        if (root == null) return new subTree(true, Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        subTree lst = getLargestBST(root.left);
        subTree rst = getLargestBST(root.right);
        boolean isBST = false;
        int count = 1+lst.countNodes+ rst.countNodes;
        if (lst.isBST && rst.isBST && root.val>lst.maxm && root.val<rst.minm){
            ans = Math.max(ans, count);
            isBST = true;
        }
        int minm = Math.min(root.val,Math.min(lst.minm,rst.minm));
        int maxm = Math.max(root.val,Math.max(lst.maxm,rst.maxm));
        return new subTree(isBST,minm,maxm,count);
    }

    private class subTree {
        boolean isBST;
        int minm;
        int maxm;
        int countNodes;
        subTree(boolean isBST,int minm,int maxm,int countNodes){
            this.isBST = isBST;
            this.minm = minm;
            this.maxm =maxm;
            this.countNodes =countNodes;
        }
    }
}
