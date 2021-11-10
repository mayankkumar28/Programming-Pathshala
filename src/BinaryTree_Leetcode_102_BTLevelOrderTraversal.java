import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Use a nested while loop, first for iterating through the tree and second for going level wise.
we sue a queue to store the current level, and in the next we store the next level but remove all the first level ones
We run this loop till all levels are traversed
 */

public class BinaryTree_Leetcode_102_BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return ans;
    }
}
