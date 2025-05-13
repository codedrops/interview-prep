/**
 * SpiralMatrix class provides a method to traverse a 2D matrix in a spiral order.
 * 
 * <p><b>Problem:</b></p>
 * Given a 2D matrix, return all elements of the matrix in spiral order.
 * 
 * <p><b>Example:</b></p>
 * Input:
 * matrix = [
 *   [1, 2, 3],
 *   [4, 5, 6],
 *   [7, 8, 9]
 * ]
 * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * 
 * <p><b>Solution Summary:</b></p>
 * The solution uses four pointers (`top`, `bottom`, `left`, `right`) to define the boundaries 
 * of the matrix. It iteratively traverses the matrix in four directions:
 * 1. From left to right along the top boundary.
 * 2. From top to bottom along the right boundary.
 * 3. From right to left along the bottom boundary (if applicable).
 * 4. From bottom to top along the left boundary (if applicable).
 * After each traversal, the respective boundary is adjusted inward. The process continues 
 * until the boundaries overlap.
 * 
 * <p><b>Notes:</b></p>
 * - Time Complexity: O(m * n), where m is the number of rows and n is the number of columns 
 *   in the matrix. Each element is visited exactly once.
 * - Space Complexity: O(1) additional space, excluding the space used for the output list.
 * 
 * <p><b>Resources:</b></p>
 * - Problem explanation: https://leetcode.com/problems/spiral-matrix/
 * - Video explanation: https://www.youtube.com/watch?v=BJnMZNwUk1M
 * 
 * <p><b>Usage:</b></p>
 * This method is useful for problems requiring traversal of a 2D matrix in a specific order, 
 * such as image processing, data visualization, or game development.
 * 
 * <p><b>Underlying Algorithm:</b></p>
 * The algorithm uses a boundary-based approach to simulate the spiral traversal. By adjusting 
 * the boundaries after each traversal, it ensures that all elements are visited in the correct 
 * order without revisiting any element.
 */
package matrix;
import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
    
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
    
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
    
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
    
            if (top <= bottom) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
    
            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
    
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println(result); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}

