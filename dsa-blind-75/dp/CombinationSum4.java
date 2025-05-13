/**
 * CombinationSum4.java
 * 
 * Problem:
 * Given an array of distinct integers `nums` and a target integer `target`, 
 * return the number of possible combinations that add up to `target`. 
 * The order of numbers in the combination matters.
 * 
 * Example:
 * Input: nums = [1, 2, 3], target = 4
 * Output: 7
 * Explanation: The possible combinations are:
 * (1, 1, 1, 1), (1, 1, 2), (1, 2, 1), (1, 3), (2, 1, 1), (2, 2), (3, 1)
 * 
 * Solution Summary:
 * - This problem is solved using dynamic programming with memoization.
 * - The `dp` array is used to store the number of combinations for each target value.
 * - The base case is `dp[0] = 1`, as there is one way to make a target of 0 (using no numbers).
 * - For each target value, iterate through the numbers in `nums` and recursively calculate 
 *   the number of combinations for `target - num`.
 * - Memoization ensures that each subproblem is solved only once, improving efficiency.
 * 
 * Notes:
 * - Time Complexity: O(target * n), where `n` is the size of the `nums` array. 
 *   For each target value, we iterate through all numbers in `nums`.
 * - Space Complexity: O(target), as we use a `dp` array of size `target + 1` and recursion stack space.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/combination-sum-iv/
 * - Dynamic Programming Explanation: https://www.geeksforgeeks.org/dynamic-programming/
 * 
 * Video Explanation:
 * - "Combination Sum IV - Dynamic Programming" by NeetCode: https://www.youtube.com/watch?v=dw2nMCxG0ik
 * 
 * Usage:
 * - This algorithm can be used to solve problems involving counting permutations or combinations 
 *   with constraints, such as coin change problems or path counting in graphs.
 * 
 * Underlying Algorithm:
 * - Dynamic Programming with Memoization:
 *   - Break the problem into smaller subproblems (finding combinations for smaller targets).
 *   - Use a `dp` array to store results of subproblems to avoid redundant calculations.
 *   - Recursively calculate the result for the current target using previously computed results.
 */
package dp;
import java.util.Arrays;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }
    
    private int helper(int[] nums, int target, int[] dp) {
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int result = 0;
        for (int num : nums) {
            result += helper(nums, target - num, dp);
        }
        dp[target] = result;
        return result;
    }

    public static void main(String[] args) {
        CombinationSum4 cs = new CombinationSum4();
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(cs.combinationSum4(nums, target)); // Output: 7
    }
}
