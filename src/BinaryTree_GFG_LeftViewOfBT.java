import java.util.ArrayList;

/*
Using a maxL integer we keep track of the level we have currently traversed
since only the first node of element should be add to list, we check if our level is greater than max level
if it is, we update our max level and add node val to our ans list

=> For printing the right view, instead of left view, we just traverse the right node first instead of left in the loop
 */



public class BinaryTree_GFG_LeftViewOfBT {
    int maxL = -1;
    ArrayList<Integer> leftView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root,0,ans);
        return ans;
    }

    void helper (TreeNode root, int level, ArrayList<Integer> ans){
        if (root == null) return;
        if (level > maxL){
            maxL = level;
            ans.add(root.val);
        }
        helper(root.left,level+1,ans);
        helper(root.right,level+1,ans);
    }
}
