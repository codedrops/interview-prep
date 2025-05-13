/**
 * This class provides a solution to the problem of finding the k-th smallest element
 * in a Binary Search Tree (BST). The k-th smallest element is determined by performing
 * an in-order traversal of the BST, which visits nodes in ascending order.
 *
 * Problem:
 * Given the root of a BST and an integer k, return the k-th smallest element in the BST.
 *
 * Example:
 * Input:
 *      Tree:       3
 *                /   \
 *               1     4
 *                \
 *                 2
 *      k = 1
 * Output: 1
 *
 * Solution Summary:
 * - The solution uses an iterative in-order traversal with the help of a stack.
 * - The in-order traversal ensures that nodes are visited in ascending order.
 * - A counter (k) is decremented each time a node is visited, and when k reaches 0,
 *   the current node's value is returned as the k-th smallest element.
 *
 * Notes:
 * - Time Complexity: O(H + k), where H is the height of the tree. In the worst case,
 *   this is O(N) for a skewed tree, and in the best case, O(log N) for a balanced tree.
 *   The k factor comes from visiting k nodes during the traversal.
 * - Space Complexity: O(H), where H is the height of the tree. This is due to the stack
 *   used for the iterative traversal.
 * - The algorithm assumes that k is valid (1 ≤ k ≤ number of nodes in the tree). If k
 *   is invalid, an IllegalArgumentException is thrown.
 *
 * Resources:
 * - For more details on in-order traversal: https://en.wikipedia.org/wiki/Tree_traversal#In-order
 * - For an explanation of BST properties: https://en.wikipedia.org/wiki/Binary_search_tree
 *
 * Video Explanation:
 * - For a visual explanation of finding the k-th smallest element in a BST, refer to:
 *   https://www.youtube.com/watch?v=5LUXSvjmGCw
 *
 * Usage:
 * - This solution can be used in scenarios where you need to find the k-th smallest
 *   element in a BST, such as in database indexing, range queries, or ranking systems.
 *
 * Underlying Algorithm:
 * - The algorithm leverages the properties of a BST and the in-order traversal technique
 *   to efficiently find the k-th smallest element.
 */
package tree;
import java.util.Stack;

public class KthSmallestElementInBST {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
    
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
    
            current = stack.pop();
            k--;
    
            if (k == 0) {
                return current.val;
            }
    
            current = current.right;
        }
    
        throw new IllegalArgumentException("k is larger than the number of nodes in the tree");
    }

    public static void main(String[] args) {
        KthSmallestElementInBST solution = new KthSmallestElementInBST();
        // Example usage
        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(1);
        root.right = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(2);
        
        int k = 1; // Find the 1st smallest element
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}

