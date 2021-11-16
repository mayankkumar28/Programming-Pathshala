import java.util.Stack;
//Inorder traversal gives bst in sorted order so we do iteration version of inorder traversal
//and just check if the next node in the stack is smaller than the previous one, which will return false

public class BST_Leetcode_98_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        pushleft(root,st);
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            if (prev != null && curr.val <= prev.val) return false;
            prev = curr;
            pushleft(root.right,st);
        }
        return true;
    }

    private void pushleft (TreeNode root,Stack st){
        while (root != null){
            st.push(root);
            root = root.left;
        }
    }
}


