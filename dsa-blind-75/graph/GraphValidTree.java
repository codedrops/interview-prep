/**
 * This class provides a solution to the problem of determining whether a given graph
 * is a valid tree. A graph is considered a valid tree if it is connected and acyclic.
 *
 * Problem:
 * - Given `n` nodes labeled from `0` to `n-1` and a list of `edges` where each edge is a pair of nodes,
 *   determine if these nodes and edges form a valid tree.
 *
 * Example:
 * - Input: n = 5, edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * - Output: true (The graph is connected and has no cycles)
 *
 * Solution Summary:
 * 1. Check if the number of edges is exactly `n-1`. If not, return false immediately.
 *    This is because a tree with `n` nodes must have exactly `n-1` edges.
 * 2. Build an adjacency list representation of the graph.
 * 3. Use Breadth-First Search (BFS) to traverse the graph:
 *    - Start from node `0` and mark it as visited.
 *    - Traverse all neighbors of the current node, marking them as visited.
 *    - Remove the back edge to prevent revisiting the parent node.
 * 4. After BFS, check if all nodes have been visited. If any node is unvisited, the graph is not connected.
 * 5. If all conditions are satisfied, return true.
 *
 * Notes:
 * - Time Complexity: O(n + e), where `n` is the number of nodes and `e` is the number of edges.
 *   - Building the graph takes O(n + e).
 *   - BFS traversal takes O(n + e).
 * - Space Complexity: O(n + e) for the adjacency list and O(n) for the visited array.
 * - The algorithm ensures both connectivity and acyclicity in a single pass using BFS.
 *
 * Resources:
 * - Graph Theory Basics: https://en.wikipedia.org/wiki/Graph_theory
 * - Trees in Graph Theory: https://en.wikipedia.org/wiki/Tree_(graph_theory)
 *
 * Video Explanation:
 * - "Graph Valid Tree Problem Explanation" by NeetCode: https://www.youtube.com/watch?v=bXsUuownnoQ
 *
 * Usage:
 * - This solution can be used to validate tree structures in network design, dependency graphs, etc.
 */
package graph;
import java.util.*;


public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return false;
        if (edges.length != n - 1) return false;
    
        // Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    
        // Use BFS to check connectivity and detect cycles
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
    
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (visited[neighbor]) continue;
                visited[neighbor] = true;
                queue.offer(neighbor);
                // Remove the back edge to prevent revisiting the parent
                graph.get(neighbor).remove((Integer) node);
            }
        }
    
        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
    
        return true;
    }
    public static void main(String[] args) {
        GraphValidTree gvt = new GraphValidTree();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(gvt.validTree(5, edges)); // Output: true
    }
}

