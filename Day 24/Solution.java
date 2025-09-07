// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { 
        val = x; 
    }
}

public class Solution {

    // Function to find the Lowest Common Ancestor (LCA)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the current node is null, p, or q, return it
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        
        // Recur for the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are not null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If one side is null, return the non-null side
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution sol = new Solution();
        TreeNode lca = sol.lowestCommonAncestor(root, root.left, root.right);
        System.out.println("LCA of 5 and 1 is: " + lca.val);  // Output: 3

        // Example 2
        lca = sol.lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println("LCA of 5 and 4 is: " + lca.val);  // Output: 5
    }
}
