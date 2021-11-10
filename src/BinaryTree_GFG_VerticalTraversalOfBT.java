import java.util.*;

/*
Using a map to store the level,list of the nodes on that level
Simply iterate using a queue and doing level order traversal, and add level as key and node to the list
queue will contain a pair of node and it's level, level will be +1 on rhs and -1 on lhs from root
keeping track of max and min levels, we can run a for loop to add all ans to single list in order
**** we can use treeMap instead of Hashmap to avoid maintaining max and min  ****
 */

public class BinaryTree_GFG_VerticalTraversalOfBT {
    public static ArrayList<Integer> verticalOrder(TreeNode root){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            pair p = q.poll();
            max = Math.max(max,p.level);
            min = Math.min(min,p.level);
            if (!map.containsKey(p.level)) map.put((p.level),new ArrayList<>());
            map.get(p.level).add(p.node.val);
            if (p.node.left != null) q.add(new pair(p.node.left,p.level-1));
            if (p.node.right != null) q.add(new pair(p.node.right,p.level+1));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = min;i<=max;i++){
            ans.addAll(map.get(i));
        }
        return ans;
    }

    private static class pair{
        TreeNode node;
        int level;

        pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
}