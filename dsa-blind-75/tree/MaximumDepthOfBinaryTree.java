/**
 * This class provides a solution to the problem of finding the maximum depth of a binary tree.
 * 
 * Problem:
 * The maximum depth of a binary tree is the number of nodes along the longest path from the root node 
 * down to the farthest leaf node. The task is to compute this depth given the root of the binary tree.
 * 
 * Example:
 * Given the binary tree:
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 * The maximum depth is 3.
 * 
 * Solution Summary:
 * - The solution uses a recursive approach to traverse the binary tree.
 * - For each node, the depth of the left and right subtrees is calculated recursively.
 * - The maximum of the two depths is taken, and 1 is added to account for the current node.
 * - The base case is when the node is null, in which case the depth is 0.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the binary tree. Each node is visited once.
 * - Space Complexity: O(h), where h is the height of the binary tree. This is the space used by the recursion stack.
 *   In the worst case (skewed tree), h can be equal to n.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * - Video Explanation: https://www.youtube.com/watch?v=hTM3phVI6YQ
 * 
 * Usage:
 * - This method can be used in scenarios where the structure of a binary tree needs to be analyzed, 
 *   such as in parsing expressions, evaluating decision trees, or analyzing hierarchical data.
 * 
 * Underlying Algorithm:
 * - The algorithm is based on Depth-First Search (DFS), which explores as far as possible along each branch 
 *   before backtracking.
 * 
 * Implementation Notes:
 * - The TreeNode class is defined as an inner class to represent the structure of a binary tree node.
 * - The main method demonstrates the usage of the `maxDepth` method with a sample binary tree.
 */


public class MaximumDepthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {}
    
        TreeNode(int val) {
            this.val = val;
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(3);
        root.left.left = tree.new TreeNode(4);
        root.left.right = tree.new TreeNode(5);
        
        System.out.println("Maximum depth of the binary tree: " + tree.maxDepth(root)); // Output: 3
    }
}

