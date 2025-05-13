/**
 * This class provides a solution to the "Maximum Subarray" problem, which is a classic
 * problem in computer science and competitive programming.
 *
 * Problem:
 * Given an integer array `nums`, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 * Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: The subarray [4, -1, 2, 1] has the largest sum = 6.
 *
 * Solution Summary:
 * - This implementation uses Kadane's Algorithm, which is an efficient approach to solve
 *   the problem in O(n) time complexity.
 * - The algorithm iterates through the array while maintaining two variables:
 *   1. `currentSum`: Tracks the maximum sum of the subarray ending at the current index.
 *   2. `maxSum`: Tracks the global maximum sum encountered so far.
 * - At each step, the algorithm decides whether to include the current element in the
 *   existing subarray or start a new subarray with the current element.
 *
 * Notes:
 * - The algorithm assumes that the input array contains at least one element.
 * - If all elements in the array are negative, the maximum subarray sum will be the
 *   largest (least negative) element.
 * - This implementation is efficient in terms of both time and space complexity:
 *   - Time Complexity: O(n), where n is the length of the input array.
 *   - Space Complexity: O(1), as no additional data structures are used.
 *
 * Resources:
 * - Kadane's Algorithm: https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * - LeetCode Problem: https://leetcode.com/problems/maximum-subarray/
 *
 * Video Explanation:
 * - Kadane's Algorithm Explained: https://www.youtube.com/watch?v=86CQq3pKSUw
 *
 * Usage:
 * - Instantiate the `MaximumSubArray` class and call the `maxSubArray` method with
 *   an integer array as input to get the maximum subarray sum.
 * 
 */


public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
    
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
    
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArray solution = new MaximumSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + solution.maxSubArray(nums)); // Output: 6
    }
}

