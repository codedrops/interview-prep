/**
 * This class provides a solution to the "Longest Increasing Subsequence" (LIS) problem.
 * 
 * Problem:
 * Given an integer array `nums`, return the length of the longest strictly increasing subsequence.
 * A subsequence is derived from an array by deleting some or no elements without changing the order 
 * of the remaining elements.
 * 
 * Example:
 * Input: nums = [10, 9, 2, 5, 3, 7, 101, 18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2, 3, 7, 101].
 * 
 * Solution Summary:
 * - Use dynamic programming to solve the problem.
 * - Maintain a `dp` array where `dp[i]` represents the length of the LIS ending at index `i`.
 * - Initialize all elements of `dp` to 1, as the minimum LIS ending at any element is 1.
 * - For each element `nums[i]`, check all previous elements `nums[j]` (where `j < i`).
 *   If `nums[i] > nums[j]`, update `dp[i]` as `dp[i] = max(dp[i], dp[j] + 1)`.
 * - Track the maximum value in the `dp` array, which represents the length of the LIS.
 * 
 * Notes:
 * - Time Complexity: O(n^2), where `n` is the length of the input array. This is due to the nested loops.
 * - Space Complexity: O(n), where `n` is the length of the input array. This is for the `dp` array.
 * - This solution is not the most optimal. A more efficient solution using binary search can achieve O(n log n).
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/longest-increasing-subsequence/
 * - Video explanation: https://www.youtube.com/watch?v=cjWnW0hdF1Y (Dynamic Programming Approach)
 * - Video explanation (Binary Search Approach): https://www.youtube.com/watch?v=22s1xxRvy28
 * 
 * Usage:
 * - This implementation is useful for understanding the dynamic programming approach to solving LIS.
 * - It can be used as a foundation for solving similar problems involving subsequences.
 * 
 * Underlying Algorithm:
 * - Dynamic Programming: The solution builds the result incrementally by solving smaller subproblems.
 * - The `dp` array stores intermediate results, avoiding redundant computations.
 * 
 * Example Usage in Main Method:
 * - Input: nums = [10, 9, 2, 5, 3, 7, 101, 18]
 * - Output: 4
 * - Explanation: The LIS is [2, 3, 7, 101].
 */


public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;
    
        // Initialize dp array with 1, as the minimum LIS ending at any element is 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
    
        // Build the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
    
        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(lis.lengthOfLIS(nums1)); // Output: 4
        System.out.println(lis.lengthOfLIS(nums2)); // Output: 4
    }
}
