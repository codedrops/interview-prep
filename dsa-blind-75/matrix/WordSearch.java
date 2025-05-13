/**
 * WordSearch.java
 * 
 * Problem:
 * This program solves the "Word Search" problem, where you are given a 2D board of characters
 * and a word. The goal is to determine if the word exists in the grid. The word can be constructed
 * from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically
 * neighboring. The same letter cell may not be used more than once.
 * 
 * Example:
 * Input:
 * board = [
 *   ['A', 'B', 'C', 'E'],
 *   ['S', 'F', 'C', 'S'],
 *   ['A', 'D', 'E', 'E']
 * ]
 * word = "ABCCED"
 * Output: true
 * 
 * Solution Summary:
 * - The solution uses Depth-First Search (DFS) to explore all possible paths in the grid.
 * - Starting from each cell in the grid, the algorithm checks if the word can be formed by
 *   recursively visiting adjacent cells.
 * - A backtracking approach is used to mark cells as visited during exploration and restore
 *   them afterward to allow other paths to use the same cells.
 * 
 * Notes:
 * - Time Complexity: O(N * 4^L), where N is the total number of cells in the grid and L is the
 *   length of the word. For each cell, we explore up to 4 directions recursively for L levels.
 * - Space Complexity: O(L), where L is the length of the word. This is the maximum depth of the
 *   recursion stack.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/word-search/
 * - Video Explanation: [Insert relevant video link here, e.g., YouTube tutorial]
 * 
 * Usage:
 * - This program can be used to solve word search puzzles in games or applications.
 * - It can also be adapted for similar grid-based search problems.
 * 
 * Underlying Algorithm:
 * - Depth-First Search (DFS) with backtracking is the core algorithm used.
 * - The grid is treated as a graph where each cell is a node, and edges exist between
 *   horizontally and vertically adjacent cells.
 * 
 * Implementation Notes:
 * - The `dfs` method performs the recursive search and handles boundary conditions.
 * - The board is temporarily modified to mark visited cells, ensuring no cell is reused
 *   in the same path.
 * - The `exist` method iterates through all cells in the grid to find a starting point
 *   for the word.
 */


public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
    
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
    
        char temp = board[i][j];
        board[i][j] = '#'; // Mark as visited
    
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);
    
        board[i][j] = temp; // Restore the original value
        return found;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(ws.exist(board, word)); // Output: false
    }
}

