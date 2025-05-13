/**
PacificAtlanticWaterFlow.java
 * 
 * Problem:
 * Given an `m x n` matrix of non-negative integers representing the height of each cell in a grid,
 * determine the list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.
 * Water can flow in all four cardinal directions (up, down, left, right) from a cell, but only if the 
 * height of the next cell is less than or equal to the current cell.
 * 
 * Example:
 * Input:
 * heights = [
 *   [1, 2, 3],
 *   [8, 9, 4],
 *   [7, 6, 5]
 * ]
 * Output:
 * [[0, 2], [1, 1], [2, 0], [2, 1], [2, 2]]
 * Explanation:
 * - Water can flow from cell (0, 2) to both oceans.
 * - Water can flow from cell (1, 1) to both oceans.
 * - Similarly, other cells in the output can flow to both oceans.
 * 
 * Solution Summary:
 * - Use Depth-First Search (DFS) to simulate water flow from the edges of the grid.
 * - Maintain two boolean matrices (`pacific` and `atlantic`) to track cells that can flow to each ocean.
 * - Start DFS from the Pacific edge (left and top borders) and Atlantic edge (right and bottom borders).
 * - For each cell, mark it as reachable for the respective ocean and recursively visit its neighbors.
 * - After processing, iterate through the grid to find cells that are reachable by both oceans.
 * 
 * Notes:
 * - Time Complexity: O(m * n), where `m` is the number of rows and `n` is the number of columns.
 *   Each cell is visited at most once for each ocean.
 * - Space Complexity: O(m * n) for the boolean matrices and recursion stack.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/pacific-atlantic-water-flow/
 * - Video explanation: [Insert relevant video link here, e.g., YouTube tutorials]
 * 
 * Additional Notes:
 * - This solution uses DFS, but Breadth-First Search (BFS) can also be used for similar results.
 * - Ensure edge cases like empty grids or single-row/column grids are handled properly.
 * 
 * Author: [Your Name]
 * Date: [Insert Date]
 */

import java.util.ArrayList;
import java.util.List;


public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();
    
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, cols - 1, Integer.MIN_VALUE);
        }
    
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, rows - 1, j, Integer.MIN_VALUE);
        }
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
    
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] ocean, int row, int col, int prevHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || ocean[row][col] || heights[row][col] < prevHeight) {
            return;
        }
    
        ocean[row][col] = true;
    
        dfs(heights, ocean, row + 1, col, heights[row][col]);
        dfs(heights, ocean, row - 1, col, heights[row][col]);
        dfs(heights, ocean, row, col + 1, heights[row][col]);
        dfs(heights, ocean, row, col - 1, heights[row][col]);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        int[][] heights = {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        };
        List<List<Integer>> result = solution.pacificAtlantic(heights);
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}
