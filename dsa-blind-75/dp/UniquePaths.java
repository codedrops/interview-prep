/**
 * The UniquePaths class provides a solution to the "Unique Paths" problem, 
 * which is a classic dynamic programming problem.
 *
 * <p>Problem:
 * A robot is located at the top-left corner of an m x n grid (marked 'Start').
 * The robot can only move either down or right at any point in time. The robot 
 * is trying to reach the bottom-right corner of the grid (marked 'Finish').
 * How many possible unique paths are there?
 *
 * <p>Example:
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Input: m = 3, n = 2
 * Output: 3
 *
 * <p>Solution Summary:
 * - Use a 2D array `dp` where `dp[i][j]` represents the number of unique paths 
 *   to reach cell (i, j).
 * - Initialize the first row and first column to 1 since there is only one way 
 *   to reach any cell in the first row or column (either moving right or down).
 * - For each cell (i, j), calculate `dp[i][j]` as the sum of the paths from the 
 *   cell above (`dp[i-1][j]`) and the cell to the left (`dp[i][j-1]`).
 * - The result is stored in `dp[m-1][n-1]`, which represents the number of 
 *   unique paths to the bottom-right corner.
 *
 * <p>Notes:
 * - Time Complexity: O(m * n), where m is the number of rows and n is the 
 *   number of columns. This is because we iterate through all cells in the grid.
 * - Space Complexity: O(m * n), as we use a 2D array to store the intermediate 
 *   results.
 * - This solution can be optimized to O(n) space by using a single array to 
 *   store the current row's results, as only the previous row is needed at any 
 *   point in time.
 *
 * <p>Resources:
 * - LeetCode Problem: https://leetcode.com/problems/unique-paths/
 * - Video Explanation: https://www.youtube.com/watch?v=IlEsdxuD4lY
 *
 * <p>Usage:
 * - This class can be used to calculate the number of unique paths in a grid 
 *   for any given dimensions m and n.
 * - Example usage is provided in the `main` method.
 *
 * <p>Underlying Algorithm:
 * - Dynamic Programming: The problem is solved by breaking it into smaller 
 *   subproblems and using the results of those subproblems to build the final 
 *   solution.
 */


public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
    
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
    
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
    
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
    
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 7)); // Output: 28
        System.out.println(up.uniquePaths(3, 2)); // Output: 3
        System.out.println(up.uniquePaths(7, 3)); // Output: 28
        System.out.println(up.uniquePaths(3, 3)); // Output: 6
    }
}

