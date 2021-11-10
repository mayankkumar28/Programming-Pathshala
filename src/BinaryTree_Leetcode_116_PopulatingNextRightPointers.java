import java.util.LinkedList;
import java.util.Queue;

//Same as level order traversal, just linking each node as we traverse

public class BinaryTree_Leetcode_116_PopulatingNextRightPointers {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return root;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                Node n = q.poll();
                size--;
                if (size != 0) n.next = q.peek();
                else n.next = null;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int _val) { val = _val; }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
