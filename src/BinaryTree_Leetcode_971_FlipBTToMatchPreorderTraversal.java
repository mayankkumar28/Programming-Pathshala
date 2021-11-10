import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
we first check whether the left child node is matching or not
if not, we flip it and then keeping checking the same for rest of the tree
we use a global variable i to keep track of level and array index
 */

public class BinaryTree_Leetcode_971_FlipBTToMatchPreorderTraversal {
    int i =0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        if (dfs(root,voyage,ans)) return ans;
        else return Arrays.asList(-1);
    }

    public boolean dfs (TreeNode root, int[] v, List<Integer> ans){
        if (root == null) return true;
        if (root.val != v[i++]) return false;
        if (root.left != null &&  root.left.val != v[i]){
            ans.add(root.val);
            return dfs(root.right,v,ans) && dfs(root.left,v,ans);
        }
        return dfs(root.right,v,ans) && dfs(root.left,v,ans);
    }
}
