/**
 * This class provides a solution to the "Maximum Product Subarray" problem.
 * 
 * Problem:
 * Given an integer array `nums`, find the contiguous subarray within the array 
 * (containing at least one number) which has the largest product and return its product.
 * 
 * Example:
 * Input: nums = [2, 3, -2, 4]
 * Output: 6
 * Explanation: The subarray [2, 3] has the largest product = 6.
 * 
 * Solution Summary:
 * - The solution uses a dynamic programming approach to keep track of the maximum and 
 *   minimum products at each index. This is necessary because a negative number can 
 *   flip the sign of the product, making the minimum product potentially the maximum 
 *   when multiplied by another negative number.
 * - At each step, the algorithm swaps the current maximum and minimum when encountering 
 *   a negative number, ensuring the correct values are used for further calculations.
 * - The global maximum product is updated at each step to ensure the largest product 
 *   is captured.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the length of the input array. The array is 
 *   traversed once.
 * - Space Complexity: O(1), as the solution uses a constant amount of extra space.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/maximum-product-subarray/
 * - Video explanation: [Insert relevant video link here, e.g., YouTube tutorials]
 * 
 * Additional Notes:
 * - The algorithm handles edge cases such as arrays with a single element, arrays 
 *   containing zeros, and arrays with all negative numbers.
 * - The initial values for `currentMax`, `currentMin`, and `maxProduct` are set to 
 *   the first element of the array to handle cases where the array has only one element.
 */


public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
    
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
    
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);
    
            maxProduct = Math.max(maxProduct, currentMax);
        }
    
        return maxProduct;
    }
    public static void main(String[] args) {
        MaximumProductSubArray solution = new MaximumProductSubArray();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + solution.maxProduct(nums)); // Output: 6
    }
}

