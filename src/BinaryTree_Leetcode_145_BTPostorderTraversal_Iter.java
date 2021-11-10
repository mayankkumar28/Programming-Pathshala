import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
There are multiple ways to do this question
One is that we do the preorder traversal and then reserve the list and return that, or push in the front of list everytime
This is one that you push each node two times and check while popping whether the curr node has been touched two times or not
if it touched and add it otherwise we have to keep looking for it's children
 */

public class BinaryTree_Leetcode_145_BTPostorderTraversal_Iter {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root == null) return ans;
        st.push(root);
        st.push(root);
        TreeNode curr;
        while (!st.empty()){
            curr = st.pop();
            if (!st.isEmpty() && st.peek()==curr){
                if (curr.right != null){
                    st.push(curr.right);
                    st.push(curr.right);
                }
                if (curr.left != null){
                    st.push(curr.left);
                    st.push(curr.left);
                }
            }
            else ans.add(curr.val);
        }
        return ans;
    }
}
