/**
 * This class provides a solution to the problem of finding the Lowest Common Ancestor (LCA)
 * of two nodes in a Binary Search Tree (BST). The LCA of two nodes p and q in a BST is defined
 * as the lowest node in the tree that has both p and q as descendants (where we allow a node
 * to be a descendant of itself).
 *
 * Problem:
 * Given the root of a Binary Search Tree (BST) and two nodes p and q, find their Lowest Common Ancestor.
 *
 * Example:
 * Input:
 *        6
 *       / \
 *      2   8
 *     / \ / \
 *    0  4 7  9
 *      / \
 *     3   5
 * p = 2, q = 8
 * Output: 6 (The root node is the LCA of nodes 2 and 8)
 *
 * Solution Summary:
 * - The algorithm leverages the properties of a BST:
 *   1. All nodes in the left subtree of a node have values less than the node's value.
 *   2. All nodes in the right subtree of a node have values greater than the node's value.
 * - Starting from the root, the algorithm checks:
 *   1. If both p and q are smaller than the current node, the LCA must be in the left subtree.
 *   2. If both p and q are greater than the current node, the LCA must be in the right subtree.
 *   3. Otherwise, the current node is the LCA.
 *
 * Notes:
 * - Time Complexity: O(h), where h is the height of the BST. In the best case (balanced BST), h = log(n),
 *   and in the worst case (skewed BST), h = n, where n is the number of nodes in the tree.
 * - Space Complexity: O(h) due to the recursive call stack.
 *
 * Resources:
 * - Binary Search Tree: https://en.wikipedia.org/wiki/Binary_search_tree
 * - Lowest Common Ancestor: https://en.wikipedia.org/wiki/Lowest_common_ancestor
 *
 * Video Explanation:
 * - "Lowest Common Ancestor in a Binary Search Tree" by NeetCode: https://www.youtube.com/watch?v=gs2LMfuOR9k
 *
 * Usage:
 * - This algorithm is useful in scenarios where you need to find relationships between nodes in a BST,
 *   such as in hierarchical data structures or decision trees.
 *
 * Underlying Algorithm:
 * - The algorithm is based on the divide-and-conquer paradigm and utilizes the BST property to efficiently
 *   locate the LCA without traversing the entire tree.
 */
package tree;

public class LowestCommonAncestorBST {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
    
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST tree = new LowestCommonAncestorBST();
        TreeNode root = tree.new TreeNode(6);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(8);
        root.left.left = tree.new TreeNode(0);
        root.left.right = tree.new TreeNode(4);
        root.right.left = tree.new TreeNode(7);
        root.right.right = tree.new TreeNode(9);
        root.left.right.left = tree.new TreeNode(3);
        root.left.right.right = tree.new TreeNode(5);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        TreeNode lca = tree.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val); // Output: 6
    }
}

