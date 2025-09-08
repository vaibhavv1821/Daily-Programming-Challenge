class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;  // Base case: empty tree is a valid BST
        }

        // Check if the current node value violates the BST property
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively check left and right subtrees with updated bounds
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(sol.isValidBST(root1));  // Output: true

        // Test case 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(sol.isValidBST(root2));  // Output: false

        // Test case 3
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(15);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(20);
        System.out.println(sol.isValidBST(root3));  // Output: false
    }
}
