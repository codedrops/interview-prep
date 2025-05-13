/**
 * This class provides a solution to the "Subtree of Another Tree" problem.
 * 
 * Problem:
 * Given the roots of two binary trees `root` and `subRoot`, determine if `subRoot` is a subtree of `root`.
 * A subtree of a binary tree `root` is a tree that consists of a node in `root` and all of its descendants.
 * The tree `root` could also be considered as a subtree of itself.
 * 
 * Example:
 * Input:
 * root = [3,4,5,1,2,null,null,null,null,0]
 * subRoot = [4,1,2]
 * Output: false
 * 
 * Solution Summary:
 * - The solution involves recursively checking if `subRoot` is identical to any subtree of `root`.
 * - The helper method `isSameTree` is used to determine if two trees are identical.
 * - If the current node of `root` matches `subRoot`, return true.
 * - Otherwise, recursively check the left and right subtrees of `root`.
 * 
 * Notes:
 * - Time Complexity: O(m * n), where `m` is the number of nodes in `root` and `n` is the number of nodes in `subRoot`.
 *   In the worst case, for each node in `root`, we compare it with all nodes in `subRoot`.
 * - Space Complexity: O(h), where `h` is the height of the tree `root`. This is due to the recursive call stack.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/subtree-of-another-tree/
 * - Video Explanation: [Insert link to a relevant video explanation]
 * 
 * Usage:
 * - This algorithm can be used in scenarios where we need to check if one tree is a subtree of another.
 * - It is particularly useful in applications involving hierarchical data structures.
 * 
 * Underlying Algorithm:
 * - The algorithm uses recursion to traverse the tree and compare nodes.
 * - The `isSameTree` method performs a depth-first traversal to check for tree equality.
 * 
 * Additional Notes:
 * - The algorithm assumes that the input trees are binary trees.
 * - Edge cases include when `root` or `subRoot` is null.
 */


public class SubTreeOfAnotherTree {
    
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
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        SubTreeOfAnotherTree tree = new SubTreeOfAnotherTree();
        TreeNode root = tree.new TreeNode(3);
        root.left = tree.new TreeNode(4);
        root.right = tree.new TreeNode(5);
        root.left.left = tree.new TreeNode(1);
        root.left.right = tree.new TreeNode(2);
        root.left.right.left = tree.new TreeNode(0);

        TreeNode subRoot = tree.new TreeNode(4);
        subRoot.left = tree.new TreeNode(1);
        subRoot.right = tree.new TreeNode(2);

        System.out.println(tree.isSubtree(root, subRoot)); // Output: true
    }
}
