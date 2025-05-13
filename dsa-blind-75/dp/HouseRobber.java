/**
 * The HouseRobber class provides a solution to the "House Robber" problem, 
 * a classic dynamic programming problem. The goal is to determine the maximum 
 * amount of money that can be robbed from a series of houses, given that 
 * adjacent houses cannot be robbed on the same night.
 *
 * Problem:
 * - You are a professional robber planning to rob houses along a street.
 * - Each house has a certain amount of money stashed, represented by an array `nums`.
 * - You cannot rob two adjacent houses.
 * - Return the maximum amount of money you can rob without alerting the police.
 *
 * Example:
 * - Input: nums = [2, 7, 9, 3, 1]
 *   Output: 12
 *   Explanation: Rob house 1 (2) + house 3 (9) + house 5 (1) = 12.
 * - Input: nums = [1, 2, 3, 1]
 *   Output: 4
 *   Explanation: Rob house 1 (1) + house 3 (3) = 4.
 *
 * Solution Summary:
 * - Use dynamic programming to solve the problem efficiently.
 * - Define a dp array where dp[i] represents the maximum amount of money 
 *   that can be robbed from the first i houses.
 * - Transition relation:
 *   dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
 *   - Either skip the current house (dp[i - 1]) or rob it (dp[i - 2] + nums[i]).
 * - Base cases:
 *   dp[0] = nums[0]
 *   dp[1] = max(nums[0], nums[1])
 * - Iterate through the array to fill the dp array and return dp[nums.length - 1].
 *
 * Notes:
 * - Time Complexity: O(n), where n is the number of houses. We iterate through the array once.
 * - Space Complexity: O(n), due to the dp array. This can be optimized to O(1) by using two variables.
 *
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/house-robber/
 * - Video Explanation: [Insert relevant video link here]
 *
 * Usage:
 * - This class can be used to solve variations of the problem, such as circular houses 
 *   (House Robber II) or houses arranged in a grid.
 *
 * Underlying Algorithm:
 * - Dynamic Programming: The problem is solved by breaking it into overlapping subproblems 
 *   and solving each subproblem only once, storing the results for future reference.
 */
package dp;

public class HouseRobber {
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
    
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
    
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
    
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums1 = {2, 7, 9, 3, 1};
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(hr.rob(nums1)); // Output: 12
        System.out.println(hr.rob(nums2)); // Output: 4
    }
}
