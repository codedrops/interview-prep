/**
 * This class provides a solution to the "Number of Islands" problem.
 * 
 * Problem:
 * Given a 2D grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands 
 * horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
 * 
 * Example:
 * Input:
 * grid = [
 *   ['1', '1', '0', '0', '0'],
 *   ['1', '1', '0', '0', '0'],
 *   ['0', '0', '1', '0', '0'],
 *   ['0', '0', '0', '1', '1']
 * ]
 * Output: 3
 * Explanation: There are three islands in the grid.
 * 
 * Solution Summary:
 * - The solution uses Breadth-First Search (BFS) to traverse the grid.
 * - Whenever a '1' (land) is encountered, it is considered the start of a new island.
 * - BFS is used to mark all connected '1's as visited by changing them to '0'.
 * - The process is repeated for all cells in the grid, and the number of islands is incremented 
 *   each time a new island is found.
 * 
 * Notes:
 * - Time Complexity: O(M * N), where M is the number of rows and N is the number of columns in the grid.
 *   Each cell is visited once.
 * - Space Complexity: O(min(M, N)), which is the maximum size of the BFS queue. In the worst case, 
 *   the queue can grow to the size of the smaller dimension of the grid.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/number-of-islands/
 * - Video explanation: https://www.youtube.com/watch?v=muncqlKJrH0
 * 
 * Usage:
 * - Instantiate the class and call the `numIslands` method with a 2D grid as input.
 * - The method returns the number of islands in the grid.
 */
package graph;
import java.util.LinkedList;
import java.util.Queue;


public class NoOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
    
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    bfs(grid, i, j);
                }
            }
        }
    
        return numIslands;
    }
    
    private void bfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
    
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = '0'; // Mark as visited
    
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
    
            for (int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];
    
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // Mark as visited
                }
            }
        }
    }

}
