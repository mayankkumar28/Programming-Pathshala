import java.util.LinkedList;
import java.util.Queue;
/*
Do level order traversal
Maintain two queues, one for traversal and one for keeping the indexes of the nodes
To number to nodes, we assign index*2 to the left node and index*2+1 to right node, it will result in exact indexes
we can then calculate the distance between the leftmost and rightmost node at that level, compare it to max
 */

public class BinaryTree_Leetcode_662_MaxWidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qIndex = new LinkedList<>();
        if (root == null) return 0;
        q.add(root);
        qIndex.add(1);
        int max = 0;
        while (!q.isEmpty()){
            int size = q.size();
            int start =0, end=0;
            for (int i =0; i<size; i++){
                TreeNode n = q.poll();
                int index = qIndex.poll();
                if (i==0) start = index;
                if (i==size-1) end = index;
                if (n.left != null) {
                    q.add(n.left);
                    qIndex.add(index*2);
                }
                if (n.right != null) {
                    q.add(n.right);
                    qIndex.add(index*2+1);
                }
            }
            max = Math.max(max,end-start+1);
        }
        return max;
    }
}