import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
We have to cal calculate distances for the parent to the target and target to the child
for parent to target we use a map to store all distances
so when we traverse through the tree and find a node that exists in map, we use it's value
for child to target we simply measure distance like we do in root to leaf traversal, inc. distance in each child call
 */

public class BinaryTree_Leetcode_863_AllNodesDistanceKinBT {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        find(root, target);
        search(root, map.get(root), K, ans);
        return ans;
    }

    public void find(TreeNode root, TreeNode target) {
        if (root == null) return;
        if (root == target) {
            map.put(root, 0);
            return;
        }
        find(root.left, target);
        if (map.containsKey(root.left)) {
            map.put(root, map.get(root.left) + 1);
            return;
        }
        find(root.right, target);
        if (map.containsKey(root.right)) {
            map.put(root, map.get(root.right) + 1);
            return;
        }
        return;
    }

    public void search(TreeNode root, int distance, int K, List<Integer> ans) {
        if (root == null) return;
        if (map.containsKey(root)) distance = map.get(root);
        if (distance == K) ans.add(root.val);
        search(root.left, distance + 1, K, ans);
        search(root.right, distance + 1, K, ans);
    }
}