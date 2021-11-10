import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Using a stack to store nodes in reverse order so that the left nodes gets popped first

public class BinaryTree_Leetcode_144_BTPreorderTraversal_Iter {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root == null) return ans;
        st.push(root);
        while (!st.empty()){
            TreeNode node = st.pop();
            ans.add(node.val);
            if (node.right!= null) st.push(node.right);
            if (node.left!= null) st.push(node.left);
        }
        return ans;
    }
}
