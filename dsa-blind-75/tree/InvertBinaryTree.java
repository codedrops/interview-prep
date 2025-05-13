/**
 * This class provides a solution to the problem of inverting a binary tree.
 * 
 * Problem:
 * Given the root of a binary tree, invert the tree, i.e., swap the left and right
 * children of all nodes in the tree.
 * 
 * Example:
 * Input:
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 * 
 * Output (Inverted Tree):
 *      1
 *     / \
 *    3   2
 *       / \
 *      5   4
 * 
 * Solution Summary:
 * - The solution uses a recursive approach to traverse the binary tree.
 * - At each node, the left and right children are swapped.
 * - The function is then recursively called on the left and right subtrees.
 * - The base case for the recursion is when the node is null, in which case
 *   the function returns null.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the tree. Each node
 *   is visited exactly once.
 * - Space Complexity: O(h), where h is the height of the tree. This is the space
 *   used by the recursion stack. In the worst case (skewed tree), h = n.
 * - The algorithm is efficient and works for both balanced and unbalanced binary trees.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/invert-binary-tree/
 * - Video Explanation: https://www.youtube.com/watch?v=OnSn2XEQ4MY
 * 
 * Usage:
 * - This method can be used in scenarios where the structure of a binary tree
 *   needs to be reversed for visualization, testing, or other purposes.
 * 
 * Underlying Algorithm:
 * - The algorithm is based on Depth-First Search (DFS) traversal of the binary tree.
 * - At each node, the left and right subtrees are swapped, and the process is repeated
 *   recursively for the child nodes.
 */


public class InvertBinaryTree {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    
        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);
    
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();
        // Example usage
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);
        
        TreeNode invertedRoot = solution.invertTree(root);
        // Helper method to print the tree in pre-order traversal
        printTree(invertedRoot);
    }

        // Method to print the tree in pre-order traversal
    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);    
    }
}

