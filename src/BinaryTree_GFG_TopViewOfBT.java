import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//Same as vertical order traversal, just adding a node val to map when we encounter it for the first time
//*** For bottom view, we simply add only the last occurrence of that level ****

public class BinaryTree_GFG_TopViewOfBT {
    public static ArrayList<Integer> verticalOrder(TreeNode root){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            pair p = q.poll();
            max = Math.max(max,p.level);
            min = Math.min(min,p.level);
            if (!map.containsKey(p.level)) map.put(p.level,p.node.val);
            if (p.node.left != null) q.add(new pair(p.node.left,p.level-1));
            if (p.node.right != null) q.add(new pair(p.node.right,p.level+1));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = min;i<=max;i++){
            ans.add(map.get(i));
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
