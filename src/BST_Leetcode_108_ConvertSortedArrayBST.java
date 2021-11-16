//Taking middle value in the sorted array will give us the most height balanced tree
//so all the values to the left will be smaller to the left in BST and likewise for right
//so we can break indexes by middle index and call them recursively till we get an empty array

public class BST_Leetcode_108_ConvertSortedArrayBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums,0,nums.length-1);
    }

    private TreeNode makeBST (int[] nums,int i, int j ){
        if (i>j) return null;
        int mid = (i+j)/2;
        TreeNode node = new TreeNode(nums[mid],null,null);
        node.left = makeBST(nums, i, mid-1);
        node.right = makeBST(nums, mid +1, j);
        return node;
    }
}
