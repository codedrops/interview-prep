/**
 * Alien Dictionary Problem:
 * --------------------------
 * Given a list of words from an alien language dictionary, where the words are sorted lexicographically
 * according to the rules of this alien language, determine the order of characters in the alien alphabet.
 * 
 * Example:
 * --------
 * Input: words = ["wrt", "wrf", "er", "ett", "rftt"]
 * Output: "wertf"
 * Explanation:
 * - From "wrt" and "wrf", we know 't' comes before 'f'.
 * - From "wrf" and "er", we know 'w' comes before 'e'.
 * - From "er" and "ett", we know 'r' comes before 't'.
 * - From "ett" and "rftt", we know 'e' comes before 'r'.
 * - Thus, the order is "wertf".
 * 
 * Solution Summary:
 * -----------------
 * 1. Build a directed graph where each character is a node, and an edge from node A to node B indicates
 *    that character A comes before character B in the alien language.
 * 2. Use a topological sort (BFS approach) to determine the order of characters.
 * 3. If a cycle is detected or the graph is invalid, return an empty string.
 * 
 * Notes:
 * ------
 * - The algorithm handles edge cases such as:
 *   - Prefix conflicts (e.g., ["abc", "ab"] is invalid because "abc" cannot come before "ab").
 *   - Disconnected components in the graph.
 * - Time Complexity: O(C), where C is the total number of characters in all words combined.
 *   - Building the graph takes O(C).
 *   - Topological sorting takes O(V + E), where V is the number of unique characters and E is the number of edges.
 * - Space Complexity: O(V + E), for storing the graph and in-degree map.
 * 
 * Resources:
 * ----------
 * - Problem Explanation: https://leetcode.com/problems/alien-dictionary/
 * - Video Explanation: https://www.youtube.com/watch?v=6kTZYvNNyps
 * 
 * Usage:
 * ------
 * - Instantiate the AlienDictionary class and call the `alienOrder` method with an array of words.
 * - Example:
 *   AlienDictionary ad = new AlienDictionary();
 *   String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
 *   System.out.println(ad.alienOrder(words)); // Output: "wertf"
 */

package graph;
import java.util.*;


public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
    
        // Initialize the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
    
        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // Invalid order
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree.put(child, inDegree.get(child) + 1);
                    }
                    break;
                }
            }
        }
    
        // Topological sort using BFS
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
    
        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            order.append(current);
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
    
        return order.length() == graph.size() ? order.toString() : "";
    }
    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(ad.alienOrder(words)); // Output: "wertf"
    }

}

