/**
 * RotateImage.java
 * 
 * Problem:
 * Given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * The rotation must be done in-place, meaning no additional 2D matrix should be used.
 * 
 * Example:
 * Input:
 * [
 *   [1, 2, 3],
 *   [4, 5, 6],
 *   [7, 8, 9]
 * ]
 * Output:
 * [
 *   [7, 4, 1],
 *   [8, 5, 2],
 *   [9, 6, 3]
 * ]
 * 
 * Solution Summary:
 * 1. Transpose the matrix: Convert rows into columns by swapping matrix[i][j] with matrix[j][i].
 * 2. Reverse each row: Reverse the elements in each row to achieve the 90-degree clockwise rotation.
 * 
 * Notes:
 * - Time Complexity: O(n^2), where n is the number of rows (or columns) in the matrix. 
 *   This is because we iterate through all elements of the matrix during the transpose and reverse operations.
 * - Space Complexity: O(1), as the rotation is performed in-place without using any additional data structures.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/rotate-image/
 * - Video Explanation: [Insert relevant video link here, e.g., YouTube tutorial]
 * 
 * Usage:
 * This algorithm is commonly used in image processing, computer graphics, and matrix manipulation problems.
 * 
 * Underlying Algorithm:
 * - Matrix Transposition: Swapping elements across the diagonal to convert rows into columns.
 * - Row Reversal: Reversing the order of elements in each row to complete the rotation.
 * 
 * Implementation Notes:
 * - Ensure the input matrix is square (n x n) as the algorithm assumes this structure.
 * - The algorithm modifies the input matrix directly, so no additional memory is allocated.
 */


public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
    
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        ri.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

