/**
 * HouseRobber2.java
 * 
 * Problem:
 * The "House Robber II" problem is a variation of the "House Robber" problem where houses are arranged in a circle.
 * You are a robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
 * but adjacent houses have security systems connected, so robbing two adjacent houses will trigger the alarm.
 * Since the houses are in a circle, the first and last houses are also adjacent.
 * 
 * Goal:
 * Determine the maximum amount of money you can rob without alerting the police.
 * 
 * Examples:
 * 1. Input: nums = [2, 3, 2]
 *    Output: 3
 *    Explanation: Rob house 2 (money = 3), as robbing house 1 and house 3 would trigger the alarm.
 * 
 * 2. Input: nums = [1, 2, 3, 1]
 *    Output: 4
 *    Explanation: Rob house 1 (money = 1) and house 3 (money = 3), as robbing adjacent houses would trigger the alarm.
 * 
 * Solution Summary:
 * - Since the houses are in a circle, the problem can be reduced to two linear "House Robber" problems:
 *   1. Rob houses from index 0 to n-2 (excluding the last house).
 *   2. Rob houses from index 1 to n-1 (excluding the first house).
 * - The maximum of these two results will be the solution.
 * - A helper function `robHelper` is used to calculate the maximum money that can be robbed for a linear range of houses.
 * - The helper function uses dynamic programming with two variables (`prev1` and `prev2`) to store the maximum money robbed
 *   up to the previous two houses, optimizing space complexity.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of houses. We iterate through the array twice (once for each range).
 * - Space Complexity: O(1), as we use only two variables to store intermediate results.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/house-robber-ii/
 * - Video Explanation: [Insert relevant video link here, e.g., YouTube tutorials on House Robber II]
 * 
 * Usage:
 * - This implementation can be used to solve variations of the "House Robber" problem where houses are arranged in a circle.
 * - It demonstrates the use of dynamic programming with space optimization.
 * 
 * Underlying Algorithm:
 * - Dynamic Programming:
 *   - Transition Relation: At each house `i`, the maximum money robbed is the maximum of:
 *     1. The money robbed up to the previous house (`prev1`).
 *     2. The money robbed up to the house before the previous house (`prev2`) plus the current house's money (`nums[i]`).
 *   - Base Cases:
 *     - If there are no houses, return 0.
 *     - If there is only one house, return its value.
 * - Circular Array Handling:
 *   - Split the problem into two linear subproblems to handle the circular adjacency constraint.
 */


public class HouseRobber2 {
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber2 hr2 = new HouseRobber2();
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        System.out.println(hr2.rob(nums1)); // Output: 3
        System.out.println(hr2.rob(nums2)); // Output: 4
    }
}

