/**
 * This class provides a solution to the "Set Matrix Zeroes" problem.
 * 
 * Problem:
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0.
 * You must do it in place without using extra space for another matrix.
 * 
 * Example:
 * Input:
 * [
 *   [1, 1, 1],
 *   [1, 0, 1],
 *   [1, 1, 1]
 * ]
 * Output:
 * [
 *   [1, 0, 1],
 *   [0, 0, 0],
 *   [1, 0, 1]
 * ]
 * 
 * Solution Summary:
 * 1. Use the first row and first column of the matrix as markers to indicate which rows and columns 
 *    need to be set to zero.
 * 2. First, check if the first row or first column contains any zeroes and store this information.
 * 3. Traverse the rest of the matrix, and for each zero found, mark its corresponding row and column 
 *    in the first row and column.
 * 4. Traverse the matrix again, and for each cell, if its row or column is marked, set it to zero.
 * 5. Finally, handle the first row and first column separately based on the initial check.
 * 
 * Notes:
 * - Time Complexity: O(m * n), where m is the number of rows and n is the number of columns. 
 *   The matrix is traversed twice.
 * - Space Complexity: O(1), as the solution uses the matrix itself for marking and does not use 
 *   any additional data structures.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/set-matrix-zeroes/
 * - Video explanation: https://www.youtube.com/watch?v=T41rL0L3Pnw
 * 
 * Usage:
 * This solution is useful for in-place matrix manipulation problems where space optimization is critical.
 * 
 * Underlying Algorithm:
 * - The algorithm leverages the first row and column of the matrix as markers to reduce space complexity.
 * - It ensures that the matrix is updated in place without requiring additional storage.
 */
package matrix;

public class SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
    
        // Check if first row has any zeros
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
    
        // Check if first column has any zeros
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
    
        // Use first row and column to mark zeros
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    
        // Set matrix cells to zero based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    
        // Set first row to zero if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
    
        // Set first column to zero if needed
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros smz = new SetMatrixZeros();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        smz.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

