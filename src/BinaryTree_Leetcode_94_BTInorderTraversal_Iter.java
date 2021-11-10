import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
We use a stack to first store all the left and root nodes first using a pushLeft func which return when no left node is present
then we pop the first element of stack and check for it's right node,if present, we again push all the left nodes of it
this pattern will always pop the left nodes first followed by the corresponding root and right nodes
 */

public class BinaryTree_Leetcode_94_BTInorderTraversal_Iter {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root == null) return ans;
        pushLeft(root,st);
        while (!st.isEmpty()){
            TreeNode temp = st.pop();
            ans.add(temp.val);
            pushLeft(temp.right,st);
        }
        return ans;
    }

    public void pushLeft (TreeNode root,Stack st){
        while (root!=null){
            st.push(root);
            root = root.left;
        }
    }
}
