import java.util.*;

//Same as level order traversal, just reversing the list at the end

public class BinaryTree_Leetcode_107_BTLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while (size != 0){
                TreeNode n = q.poll();
                temp.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right!= null) q.add(n.right);
                size--;
            }
            ans.add(temp);
        }
        Collections.reverse(ans);
        return ans;
    }
}
