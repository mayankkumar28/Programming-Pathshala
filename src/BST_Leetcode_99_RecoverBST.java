/*
We have to search for two odd values in the inorder sorted array and swap their values
to reduce space complexity, we only maintain 2 pointers, current and prev one
edge could be there when values are adjacent, so when odd val is found for first time, we take both curr and prev values
else for 2nd time we update our 2 pointer val to the curr value
 */

public class BST_Leetcode_99_RecoverBST {
    TreeNode prev,n1,n2;int count;
    public void recoverTree(TreeNode root) {
        count = 0;
        prev= null;
        if (root == null) return;
        inorder(root);
        swap(n1,n2);
    }

    private void inorder(TreeNode root){
        inorder(root.left);
        if (prev == null) prev = root;
        else {
            if (prev.val > root.val) {
                count++;
                if (count == 1){
                    n1 = prev;
                    n2 = root;
                }
                else if (count == 2){
                    n2 = root;
                }
            }
            prev = root;
        }
        inorder(root.right);
    }

    private void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
