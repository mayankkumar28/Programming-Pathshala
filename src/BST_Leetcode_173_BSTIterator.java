import java.util.ArrayList;

//simply using an array and inorder traversal to traverse the tree, stack approach can be used to reduce space complexity

public class BST_Leetcode_173_BSTIterator {
    ArrayList<Integer> inorderList = new ArrayList<>();
    int index = 0;

    private void traverse (TreeNode root){
        if (root == null) return;
        traverse (root.left);
        inorderList.add(root.val);
        traverse(root.right);
    }

    private BST_Leetcode_173_BSTIterator(TreeNode root) {
        traverse(root);
    }

    private int next() {
        return inorderList.get(index++);
    }

    private boolean hasNext() {
        return index<inorderList.size();
    }
}
