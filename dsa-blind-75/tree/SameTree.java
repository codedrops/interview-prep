
/**
 * This class provides a solution to the "Same Tree" problem.
 * 
 * Problem:
 * Given the roots of two binary trees, determine if they are the same. 
 * Two binary trees are considered the same if they are structurally identical 
 * and the nodes have the same value.
 * 
 * Example:
 * Input: 
 * Tree 1:    1         Tree 2:    1
 *           / \                  / \
 *          2   3                2   3
 * Output: true
 * 
 * Input: 
 * Tree 1:    1         Tree 2:    1
 *           /                    / \
 *          2                    2   3
 * Output: false
 * 
 * Solution Summary:
 * - The solution uses recursion to traverse both trees simultaneously.
 * - Base cases:
 *   1. If both nodes are null, return true (both trees are empty at this point).
 *   2. If one node is null and the other is not, or if their values differ, return false.
 * - Recursive case:
 *   - Check if the left subtrees and right subtrees of both nodes are the same.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the smaller tree. 
 *   Each node is visited once.
 * - Space Complexity: O(h), where h is the height of the tree. This is due to 
 *   the recursive call stack.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/same-tree/
 * - Video Explanation: https://www.youtube.com/watch?v=vRbbcKXCxOw
 * 
 * Usage:
 * - This algorithm can be used to compare two binary trees in various applications 
 *   such as tree-based data structures, file system comparisons, or XML/JSON tree comparisons.
 * 
 * Underlying Algorithm:
 * - Depth-First Search (DFS) is used to traverse the trees recursively.
 * - The algorithm ensures that both structure and values are compared at every level.
 */


public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static class TreeNode {
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

    public static void main(String[] args) {
        SameTree tree = new SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        
        System.out.println("Are the two trees the same? " + tree.isSameTree(p, q)); // Output: true
    }
}

