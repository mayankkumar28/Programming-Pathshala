import java.util.ArrayList;
import java.util.List;

//Plain recursion to fetch left first and then add root and then right using a helper function

public class BinaryTree_Leetcode_145_BTPostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        postOrder(root,ans);
        return ans;
    }

    public void postOrder (TreeNode root, List<Integer> ans){
        if (root == null) return;
        postOrder(root.left,ans);
        postOrder(root.right,ans);
        ans.add(root.val);
    }
}
