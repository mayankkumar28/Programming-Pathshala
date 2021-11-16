import java.util.Stack;

/*Can simply be done by using an array and doing inorder traversal, then using 2 pointers to determine the sum
for O(height) complexity we do inorder using 2 stacks, one for sorted and other for reverse sorted
we start from top of both the stacks, and if we find the value then we return true
else we add rest of the elements depending on the current sum, and terminate when so stacks throws same node(i==j) no val found
 */

public class BST_GFG_PairSum {
    public int isPairPresent(TreeNode root, int target){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        TreeNode node = root;
        while (node != null){
            st1.push(node);
            node = node.left;
        }
        node = root;
        while (node != null){
            st2.push(node);
            node = node.right;
        }

        while (st1.peek() != st2.peek()){
            int x = st1.peek().val;
            int y = st2.peek().val;
            if (x+y == target) return 1;
            else if (x+y < target) moveLeft(st1);
            else moveRight(st2);
        }
        return 0;
    }

    public void moveLeft(Stack<TreeNode> st1){
        TreeNode temp = st1.pop();
        TreeNode node = temp.right;
        while (node != null){
            st1.push(node);
            node = node.left;
        }
    }
    //reverse Inorder
    public void moveRight(Stack<TreeNode>  st2){
        TreeNode temp =  st2.pop();
        TreeNode node = temp.left;
        while (node != null){
            st2.push(node);
            node = node.right;
        }
    }
}
