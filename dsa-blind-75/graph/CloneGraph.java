/**
 * CloneGraph.java
 * 
 * Problem:
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * 
 * Example:
 * Input: A graph with nodes connected as follows:
 * 1 -- 2
 * |    |
 * 4 -- 3
 * Output: A deep copy of the graph with the same structure and values.
 * 
 * Solution Summary:
 * - The solution uses Depth-First Search (DFS) to traverse the graph and create a deep copy.
 * - A HashMap is used to store the mapping between original nodes and their cloned counterparts.
 * - For each node, if it has already been visited, return the cloned node from the map.
 * - Otherwise, create a new node, add it to the map, and recursively clone its neighbors.
 * 
 * Notes:
 * - Time Complexity: O(V + E), where V is the number of vertices (nodes) and E is the number of edges in the graph.
 *   Each node and edge is visited once during the DFS traversal.
 * - Space Complexity: O(V), due to the HashMap used to store the visited nodes and the recursion stack.
 * - The graph is assumed to be connected and undirected.
 * - The input graph may contain cycles, which are handled by the visited map to avoid infinite recursion.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/clone-graph/
 * - Video Explanation: https://www.youtube.com/watch?v=f2EfGComRKM
 * 
 * Usage:
 * - This implementation can be used to clone any connected undirected graph represented using adjacency lists.
 * - Example usage is provided in the main method, where a sample graph is created and cloned.
 */
package graph;
import java.util.*;

public class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
    
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
    
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
    
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }
    
    private Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
    
        Node clone = new Node(node.val);
        visited.put(node, clone);
    
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }
    
        return clone;
    }
 
    public static void main(String[] args) {
        // Example usage
        CloneGraph cg = new CloneGraph();
        Node node1 = cg.new Node(1);
        Node node2 = cg.new Node(2);
        Node node3 = cg.new Node(3);
        Node node4 = cg.new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        
        Node clonedGraph = cg.cloneGraph(node1);
        // Print cloned graph nodes
        System.out.println("Cloned Graph:");
        for (Node n : clonedGraph.neighbors) {
            System.out.println("Node " + n.val + " neighbors: " + n.neighbors.stream().map(neighbor -> neighbor.val).toList());
        }
    }
}

