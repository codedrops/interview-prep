/**
 * This class provides a solution to the "Product of Array Except Self" problem.
 * 
 * Problem:
 * Given an integer array `nums`, return an array `answer` such that `answer[i]`
 * is equal to the product of all the elements of `nums` except `nums[i]`.
 * The solution must be implemented without using division and in O(n) time complexity.
 * 
 * Example:
 * Input: nums = [1, 2, 3, 4]
 * Output: [24, 12, 8, 6]
 * Explanation:
 * - For index 0: Product except self = 2 * 3 * 4 = 24
 * - For index 1: Product except self = 1 * 3 * 4 = 12
 * - For index 2: Product except self = 1 * 2 * 4 = 8
 * - For index 3: Product except self = 1 * 2 * 3 = 6
 * 
 * Solution Summary:
 * 1. Use a result array to store the product of elements to the left of each index.
 * 2. Traverse the array from left to right, calculating the cumulative product of elements.
 * 3. Use a variable `rightProduct` to calculate the product of elements to the right of each index.
 * 4. Traverse the array from right to left, updating the result array by multiplying with `rightProduct`.
 * 5. This approach avoids division and achieves O(n) time complexity with O(1) additional space (excluding the output array).
 * 
 * Notes:
 * - The result array is initialized with 1 to handle the product calculation.
 * - The algorithm ensures no division is used, making it robust for cases where `nums` contains zero.
 * - The space complexity is O(1) (excluding the output array) since no additional data structures are used.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/product-of-array-except-self/
 * - Related Topics: Arrays, Prefix Sum, Space Optimization
 * 
 * Video Explanation:
 * - NeetCode: https://www.youtube.com/watch?v=bNvIQI2wAjk
 * - TechDose: https://www.youtube.com/watch?v=ZDaZxxk2Sb8
 */
package array;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Initialize the result array with 1 for the product calculation
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate the product of elements to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.print("Product of array except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

