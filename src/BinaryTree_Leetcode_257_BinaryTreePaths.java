/*
Here we have to print all the tree paths from root to each leaves
for this we recurse till end of the path,adding all the nodes in process
if we reach null we return, if we are at a leaf, we add it to our list, else we keep going
while returning/backtracking we pop out the last element, so that new ones can be added in that path/place
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_Leetcode_257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        countNodes(ans,root,sb);
        return ans;
    }

    public void countNodes(List<String> ans, TreeNode root, StringBuilder sb){
        if (root== null) return;
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right ==null) ans.add(sb.toString());
        else {
            sb.append("->");
            countNodes(ans,root.left,sb);
            countNodes(ans,root.right,sb);
        }
        sb.setLength(len);
    }
}
