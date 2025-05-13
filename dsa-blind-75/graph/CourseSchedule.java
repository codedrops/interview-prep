/**
 * This class provides a solution to the "Course Schedule" problem, which is a classic graph problem.
 * The goal is to determine if it is possible to finish all courses given a list of prerequisite pairs.
 *
 * Problem:
 * - You are given `numCourses` representing the total number of courses labeled from 0 to numCourses-1.
 * - You are also given an array `prerequisites` where prerequisites[i] = [ai, bi] indicates that you must take course `bi` before course `ai`.
 * - Return true if you can finish all courses, otherwise return false.
 *
 * Example:
 * 1. Input: numCourses = 2, prerequisites = [[1, 0]]
 *    Output: true
 *    Explanation: You can take course 0 first, then course 1.
 * 
 * 2. Input: numCourses = 2, prerequisites = [[1, 0], [0, 1]]
 *    Output: false
 *    Explanation: There is a cycle between course 0 and course 1, so it is impossible to finish all courses.
 *
 * Solution Summary:
 * - The problem is modeled as a directed graph where courses are nodes and prerequisites are directed edges.
 * - A cycle in the graph indicates that it is impossible to complete all courses.
 * - The solution uses Depth-First Search (DFS) to detect cycles in the graph.
 * - An adjacency list is used to represent the graph, and a `visited` array is used to track the state of each node:
 *   - 0: Unvisited
 *   - 1: Visiting (currently in the recursion stack)
 *   - 2: Visited (already processed)
 * - If a node is encountered in the "Visiting" state during DFS, a cycle is detected.
 *
 * Notes:
 * - Time Complexity: O(V + E), where V is the number of courses (vertices) and E is the number of prerequisite pairs (edges).
 *   - Building the adjacency list takes O(E).
 *   - Each node and edge is visited once during the DFS traversal.
 * - Space Complexity: O(V + E) for the adjacency list and O(V) for the visited array and recursion stack.
 *
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/course-schedule/
 * - Video Explanation: [Insert relevant video link here, e.g., YouTube tutorials on Course Schedule problem]
 *
 * Additional Notes:
 * - This implementation assumes that the input is valid and does not contain invalid course indices.
 * - The algorithm can be extended to return the order of courses (topological sort) if required.
 */


import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
    
        // Array to track visited nodes: 0 = unvisited, 1 = visiting, 2 = visited
        int[] visited = new int[numCourses];
    
        // Perform DFS to detect cycles
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) {
            return true; // Cycle detected
        }
        if (visited[course] == 2) {
            return false; // Already processed
        }
    
        visited[course] = 1; // Mark as visiting
        for (int neighbor : graph.get(course)) {
            if (hasCycle(graph, visited, neighbor)) {
                return true;
            }
        }
        visited[course] = 2; // Mark as visited
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(cs.canFinish(numCourses, prerequisites)); // Output: true

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(cs.canFinish(numCourses, prerequisites)); // Output: false
    }
}
