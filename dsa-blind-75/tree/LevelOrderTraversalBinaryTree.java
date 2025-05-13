/**
 * This class provides a solution to perform level order traversal (breadth-first traversal)
 * on a binary tree. The traversal visits all nodes at each depth level from left to right.
 *
 * Problem:
 * Given the root of a binary tree, return its level order traversal as a list of lists,
 * where each inner list contains the values of nodes at the same depth level.
 *
 * Example:
 * Input: 
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 * Output: [[1], [2, 3], [4, 5]]
 *
 * Solution Summary:
 * - Use a queue to perform a breadth-first traversal of the binary tree.
 * - For each level, process all nodes in the queue, adding their values to a list.
 * - Add the children of the current node to the queue for processing in the next level.
 * - Continue until all levels are processed and the queue is empty.
 *
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the binary tree.
 *   Each node is visited exactly once.
 * - Space Complexity: O(n), where n is the maximum number of nodes at any level
 *   (the width of the tree). This is the space required for the queue.
 *
 * Resources:
 * - Binary Tree Level Order Traversal: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * - Breadth-First Search (BFS) Algorithm: https://en.wikipedia.org/wiki/Breadth-first_search
 *
 * Video Explanation:
 * - "Binary Tree Level Order Traversal" by NeetCode: https://www.youtube.com/watch?v=6ZnyEApgFYg
 *
 * Usage:
 * - This algorithm is useful for problems that require processing nodes level by level,
 *   such as finding the maximum width of a binary tree or determining the average value
 *   of nodes at each level.
 *
 * Underlying Algorithm:
 * - Breadth-First Search (BFS) is used to traverse the binary tree level by level.
 * - A queue is employed to manage the nodes to be processed at each level.
 */
package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {
    
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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
    
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
    
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
    
            result.add(currentLevel);
        }
    
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversalBinaryTree tree = new LevelOrderTraversalBinaryTree();
        TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(3);
        root.left.left = tree.new TreeNode(4);
        root.left.right = tree.new TreeNode(5);
    
        List<List<Integer>> result = tree.levelOrder(root);
        System.out.println(result); // Output: [[1], [2, 3], [4, 5]]
    }
}
