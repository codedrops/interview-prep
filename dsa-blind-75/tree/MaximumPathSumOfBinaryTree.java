/**
 * This class provides a solution to the "Maximum Path Sum of Binary Tree" problem.
 * 
 * Problem:
 * Given a binary tree, find the maximum path sum. A path in a binary tree is defined as 
 * any sequence of nodes from some starting node to any node in the tree along the parent-child 
 * connections. The path must contain at least one node and does not need to go through the root.
 * 
 * Example:
 * Input: 
 *        -10
 *       /   \
 *      9     20
 *           /  \
 *          15   7
 * Output: 42
 * Explanation: The path with the maximum sum is 15 -> 20 -> 7.
 * 
 * Solution Summary:
 * - Use a recursive helper function `calculatePathSum(TreeNode node)` to calculate the maximum 
 *   path sum for each subtree.
 * - For each node, calculate the maximum path sum that includes the node and its left and right 
 *   subtrees. Update the global `maxSum` variable if this sum is greater than the current value.
 * - Return the maximum path sum that can be extended to the parent node (either through the left 
 *   or right subtree).
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the binary tree. Each node is visited once.
 * - Space Complexity: O(h), where h is the height of the binary tree. This is the space used by the 
 *   recursion stack.
 * 
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * - Video explanation: https://www.youtube.com/watch?v=Hr5cWUld4vU
 * 
 * Usage:
 * - This algorithm can be used in scenarios where you need to find the maximum sum of paths in 
 *   hierarchical structures like trees or graphs.
 * 
 * Underlying Algorithm:
 * - Depth-First Search (DFS) is used to traverse the tree and calculate the maximum path sum for 
 *   each subtree.
 * - Dynamic programming is applied implicitly by storing the maximum path sum for each subtree 
 *   and reusing it to calculate the result for the parent node.
 */


public class MaximumPathSumOfBinaryTree {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        calculatePathSum(root);
        return maxSum;
    }
    
    private int calculatePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
    
        int leftSum = Math.max(0, calculatePathSum(node.left));
        int rightSum = Math.max(0, calculatePathSum(node.right));
    
        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);
    
        return Math.max(leftSum, rightSum) + node.val;
    }

    public static void main(String[] args) {
        MaximumPathSumOfBinaryTree tree = new MaximumPathSumOfBinaryTree();
        
        TreeNode root = tree.new TreeNode(-10);
        root.left = tree.new TreeNode(9);
        root.right = tree.new TreeNode(20);
        root.right.left = tree.new TreeNode(15);
        root.right.right = tree.new TreeNode(7);
        
        int result = tree.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }
}
