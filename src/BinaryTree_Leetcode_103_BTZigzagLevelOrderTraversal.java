import java.util.*;

/*
In zigzag we have to reverse the order for the odd level
So we perform level order, but for odd levels we store the nodes in a stack
and then empty that stack at the end of the loop, which will reverse their order
for level order we use a queue, add left and right nodes of present nodes at that level and remove all nodes for that level
 */

public class BinaryTree_Leetcode_103_BTZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        q.add(root);
        int level =0;
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while (size!=0){
                TreeNode n = q.poll();
                if (level%2!=0) st.add(n.val);
                else temp.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                size--;
            }
            if (level %2 != 0){
                while (!st.isEmpty()) temp.add(st.pop());
            }
            ans.add(temp);
            level++;
        }
        return ans;
    }
}