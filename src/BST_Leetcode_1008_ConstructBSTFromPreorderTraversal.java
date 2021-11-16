/*
In preorder traversal, first will be root then the lst and the rst
so we start from root, then break into lst and rst, values of which will be less for lst and more for rst
we can call a recursion function for each subtree till it satisfies this condition or we reach the empty array
 */

public class BST_Leetcode_1008_ConstructBSTFromPreorderTraversal {
    int i =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return givemebst(preorder,Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    private TreeNode givemebst (int[] preorder, int start,int end){
        if(i == preorder.length || preorder[i]<start || preorder[i]>end) return null;
        TreeNode node = new TreeNode (preorder[i++],null,null);
        node.left = givemebst(preorder, start, node.val);
        node.right = givemebst(preorder, node.val, end);
        return node;
    }
}
