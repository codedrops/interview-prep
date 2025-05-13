/**
 * ValidateBinarySearchTree
 * 
 * Problem:
 * This class provides a solution to validate if a given binary tree is a Binary Search Tree (BST).
 * A BST is defined as a binary tree in which for every node:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 * 
 * Example:
 * Input: [2, 1, 3]
 *        2
 *       / \
 *      1   3
 * Output: true
 * 
 * Input: [5, 1, 4, null, null, 3, 6]
 *        5
 *       / \
 *      1   4
 *         / \
 *        3   6
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4, which violates the BST property.
 * 
 * Solution Summary:
 * The solution uses a recursive helper function `validate` that checks whether the current node's value
 * lies within a valid range defined by `lower` and `upper` bounds. The bounds are updated as we traverse
 * down the tree:
 * - For the left subtree, the upper bound is updated to the current node's value.
 * - For the right subtree, the lower bound is updated to the current node's value.
 * If any node violates the BST property, the function returns false.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited once.
 * - Space Complexity: O(h), where h is the height of the tree. This is the space used by the recursion stack.
 *   In the worst case (skewed tree), h = n. In the best case (balanced tree), h = log(n).
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/validate-binary-search-tree/
 * - Video Explanation: https://www.youtube.com/watch?v=s6ATEkipzow
 * 
 * Usage:
 * - This class can be used to validate if a given binary tree satisfies the BST properties.
 * - It is useful in scenarios where tree structures need to be verified for correctness, such as in database indexing.
 * 
 * Underlying Algorithm:
 * - The algorithm uses Depth-First Search (DFS) to traverse the tree and validate the BST properties.
 * - It leverages the concept of range constraints to ensure that each node satisfies the BST rules.
 */


public class ValidateBinarySearchTree {

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
    
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
    
        int val = node.val;
    
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
    
        if (!validate(node.right, val, upper)) {
            return false;
        }
        if (!validate(node.left, lower, val)) {
            return false;
        }
    
        return true;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        TreeNode root = vbst.new TreeNode(2);
        root.left = vbst.new TreeNode(1);
        root.right = vbst.new TreeNode(3);
        
        System.out.println(vbst.isValidBST(root)); // Output: true
    }
}

