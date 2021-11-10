import java.util.ArrayList;
import java.util.List;

//Plain recursion to fetch left first and then right using a helper function

public class BinaryTree_Leetcode_144_BTPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }

    public void preorder(TreeNode root, List<Integer> ans){
        if (root == null) return;
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
}
