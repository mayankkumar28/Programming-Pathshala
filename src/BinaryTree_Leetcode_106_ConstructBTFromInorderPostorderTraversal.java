import java.util.HashMap;

//Revise
//We find the root (last element in postorder) in Inorder and break into two, and keep doing it till we get single elements

public class BinaryTree_Leetcode_106_ConstructBTFromInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length-1, postorder, postorder.length-1,map);
    }

    private TreeNode helper(int[] inorder, int instart, int inend, int[] postorder,int posstart,HashMap<Integer, Integer> map) {
        if (instart > inend || posstart < 0) return null;
        TreeNode root = new TreeNode(postorder[posstart]);
        int index = map.get(root.val);
        root.left = helper(inorder, instart, index - 1, postorder, posstart - (inend - index) - 1,map);
        root.right = helper(inorder, index + 1, inend, postorder, posstart - 1,map);
        return root;
    }
}
