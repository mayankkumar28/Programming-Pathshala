//Same as constructing from preorder, we just start from back to front of array and call for right subtree first

public class BST_GFG_ConstructBSTFromPostorder {
    int i;
    public TreeNode constructTree(int post[],int n) {
        i=n-1;
        return givemebst(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode givemebst (int[] preorder, int start,int end){
        if(i < 0 || preorder[i]<start || preorder[i]>end) return null;
        TreeNode node = new TreeNode (preorder[i--]);
        node.right = givemebst(preorder, node.val,end);
        node.left = givemebst(preorder, start, node.val);
        return node;
    }
}
