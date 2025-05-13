/**
 * This class provides a solution to the problem of finding the number of connected components
 * in an undirected graph. A connected component is a subset of nodes such that there is a path
 * between any two nodes in the subset, and the subset is connected to no additional nodes in the graph.
 *
 * Problem:
 * Given `n` nodes labeled from `0` to `n-1` and a list of edges where each edge is a pair of nodes,
 * determine the number of connected components in the graph.
 *
 * Example:
 * Input:
 * n = 5, edges = [[0, 1], [1, 2], [3, 4]]
 * Output:
 * 2
 * Explanation:
 * The graph has two connected components:
 * - Component 1: Nodes {0, 1, 2}
 * - Component 2: Nodes {3, 4}
 *
 * Solution Summary:
 * 1. Represent the graph using an adjacency list.
 * 2. Use a boolean array to track visited nodes.
 * 3. Perform a Depth-First Search (DFS) starting from each unvisited node to explore all nodes
 *    in its connected component.
 * 4. Increment the count of connected components for each DFS traversal.
 *
 * Notes:
 * - Time Complexity: O(V + E), where V is the number of nodes and E is the number of edges.
 *   - Constructing the adjacency list takes O(E).
 *   - Each node and edge is visited once during the DFS traversal.
 * - Space Complexity: O(V + E), where V is the space for the adjacency list and visited array,
 *   and E is the space for the adjacency list edges.
 *
 * Resources:
 * - Graph Theory Basics: https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)
 * - Depth-First Search (DFS): https://en.wikipedia.org/wiki/Depth-first_search
 *
 * Video Explanation:
 * - "Number of Connected Components in an Undirected Graph" by NeetCode:
 *   https://www.youtube.com/watch?v=bXsUuownnoQ
 */
package graph;
import java.util.*;


public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    
        // Visited array to track visited nodes
        boolean[] visited = new boolean[n];
        int components = 0;
    
        // Perform DFS for each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }
    
        return components;
    }
    
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
    public static void main(String[] args) {
        NumberOfConnectedComponents solution = new NumberOfConnectedComponents();
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5;
        System.out.println(solution.countComponents(n, edges)); // Output: 2
    }
}
