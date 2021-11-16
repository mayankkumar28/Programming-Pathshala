//Inorder travel of a BST gives us the sorted order of the tree,
// so we do inorder traversal and inc. count each time and when count is equal to our K, we return that value

public class BST_Leetcode_230_KthSmallestElementInBST {
    int count=0;int ans;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return ans;
    }

    public void traverse (TreeNode root,int k){
        if (root == null) return;
        traverse(root.left,k);
        count++;
        if (count == k){
            ans = root.val;
            return;
        }
        traverse(root.right,k);
    }
}
