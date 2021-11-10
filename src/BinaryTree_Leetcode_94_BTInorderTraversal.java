import java.util.ArrayList;
import java.util.List;

//Plain recursion to fetch left first and then add root and then right using a helper function

public class BinaryTree_Leetcode_94_BTInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }

    public void inOrder(TreeNode root, List<Integer> ans){
        if (root == null) return;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}
