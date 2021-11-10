//one function to find the lca, distance will be dist. from a to lca + b to lca

public class BinaryTree_GFG_MinDistanceBetween2Nodes {

    public int findDist(TreeNode root, int a, int b) {
        TreeNode lca = findLCA(root,a,b);
        int l1 = distance(lca,a,0);
        int l2 = distance(lca,b,0);
        return l1+l2;
    }

    private TreeNode findLCA (TreeNode root,int a, int b){
        if (root == null) return null;
        if (root.val == a || root.val == b) return root;
        TreeNode lst = findLCA(root.left,a,b);
        TreeNode rst = findLCA(root.right,a,b);
        if (lst == null) return rst;
        if (rst == null) return lst;
        return root;
    }

    private int distance (TreeNode root, int a,int dist){
        if (root == null) return -1;
        if (root.val == a) return dist;
        int lst = distance(root.left,a,dist+1);
        if (lst != -1) return lst;
        return distance(root.right,a,dist+1);
    }
}
