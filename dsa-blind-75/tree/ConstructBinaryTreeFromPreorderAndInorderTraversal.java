/**
 * This class provides a solution to construct a binary tree from its preorder and inorder traversal arrays.
 * 
 * Problem:
 * Given two integer arrays `preorder` and `inorder` where:
 * - `preorder` is the preorder traversal of a binary tree.
 * - `inorder` is the inorder traversal of the same binary tree.
 * Construct and return the binary tree.
 * 
 * Example:
 * Input:
 * preorder = [3, 9, 20, 15, 7]
 * inorder = [9, 3, 15, 20, 7]
 * Output:
 * The constructed binary tree:
 *        3
 *       / \
 *      9  20
 *         / \
 *        15  7
 * 
 * Solution Summary:
 * - The first element of the `preorder` array is the root of the tree.
 * - Using the `inorder` array, find the index of the root element to determine the left and right subtrees.
 * - Recursively construct the left and right subtrees using the respective segments of the `preorder` and `inorder` arrays.
 * - A HashMap is used to store the indices of elements in the `inorder` array for O(1) lookup.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the tree. Each node is processed once, and the HashMap lookup is O(1).
 * - Space Complexity: O(n), for the HashMap and the recursive call stack in the worst case (skewed tree).
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * - Video Explanation: https://www.youtube.com/watch?v=ihj4IQGZ2zc
 * 
 * Usage:
 * - This solution can be used to reconstruct a binary tree when its preorder and inorder traversals are known.
 * - Useful in scenarios where tree structure needs to be recreated from traversal data.
 * 
 * Underlying Algorithm:
 * - Divide and Conquer: The problem is broken down into smaller subproblems (constructing left and right subtrees),
 *   and the solutions to these subproblems are combined to solve the original problem.
 * 
 * How to Verify:
 * - After constructing the tree, perform a preorder and inorder traversal of the tree and compare the results
 *   with the input arrays to ensure correctness.
 */
package tree;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
    
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
    
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
    
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
    
        int rootIndex = inorderMap.get(rootVal);
        int leftTreeSize = rootIndex - inStart;
    
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, rootIndex - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd, inorderMap);
    
        return root;
    }

        public static void main(String[] args) {
            ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder = {9, 3, 15, 20, 7};
            TreeNode root = solution.buildTree(preorder, inorder);
            System.out.println("Root of the tree: " + (root != null ? root.val : "null"));
        }
    
}    

