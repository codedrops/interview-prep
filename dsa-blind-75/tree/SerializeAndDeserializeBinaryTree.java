/**
 * SerializeAndDeserializeBinaryTree
 *
 * Problem:
 * This class provides functionality to serialize and deserialize a binary tree.
 * Serialization is the process of converting a binary tree into a string representation,
 * and deserialization is the reverse process of reconstructing the binary tree from its string representation.
 *
 * Example:
 * Input Tree:
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 * Serialized String: "1,2,4,null,null,5,null,null,3,null,null,"
 * Deserialized Tree: Reconstructs the same tree as the input.
 *
 * Solution Summary:
 * - Serialization is performed using a pre-order traversal (root, left, right).
 *   Null nodes are represented as "null" in the serialized string, and values are separated by commas.
 * - Deserialization uses a queue to reconstruct the tree by reading values in the same order as they were serialized.
 *   The queue ensures that nodes are processed in the correct order for reconstruction.
 *
 * Notes:
 * - Time Complexity:
 *   - Serialization: O(n), where n is the number of nodes in the tree. Each node is visited once.
 *   - Deserialization: O(n), where n is the number of nodes in the tree. Each node is processed once.
 * - Space Complexity:
 *   - Serialization: O(n), for the StringBuilder used to store the serialized string.
 *   - Deserialization: O(n), for the queue used to store the nodes during reconstruction.
 * - The solution assumes that the input tree does not contain cycles (i.e., it is a valid binary tree).
 *
 * Resources:
 * - For more details on tree traversal algorithms: https://en.wikipedia.org/wiki/Tree_traversal
 * - For understanding serialization and deserialization concepts: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Video Explanation:
 * - A helpful video explaining the concept: https://www.youtube.com/watch?v=u4JAi2JJhI8
 *
 * Usage:
 * - This class can be used in scenarios where binary trees need to be stored or transmitted as strings,
 *   such as in distributed systems or file storage.
 *
 * Underlying Algorithm:
 * - The solution uses pre-order traversal for serialization and a queue-based approach for deserialization.
 * - The use of "null" as a placeholder ensures that the tree structure is preserved during serialization.
 */
package tree;

public class SerializeAndDeserializeBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }
    
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeHelper(new java.util.LinkedList<>(java.util.Arrays.asList(nodes)));
    }
    
    private TreeNode deserializeHelper(java.util.Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree tree = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        String serialized = tree.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = tree.deserialize(serialized);
        String reSerialized = tree.serialize(deserializedRoot);
        System.out.println("Re-Serialized: " + reSerialized);
    }
}
