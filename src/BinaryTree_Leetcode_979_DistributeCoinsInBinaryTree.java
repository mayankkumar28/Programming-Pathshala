/*
Main idea is that every node will have exactly one coin each.
So the number of moves will be equal top the number of coins it gives out or takes in case of zero
so we do a dfs, and then return the number of excessive coins to it's parent by sub. 1 for each node
moves will be taken as abs values because -ve will also result in moves towards them
 */

public class BinaryTree_Leetcode_979_DistributeCoinsInBinaryTree {
    int ans=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);  //excess coins from left
        int right = dfs(root.right); //excess coins from right
        int curr = root.val-1;  //curr node excess coins
        ans += Math.abs(left) + Math.abs(right);  //no of moves added
        return curr+left+right;  //returning extra coin to parent
    }
}
