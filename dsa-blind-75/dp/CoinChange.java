/**
 * CoinChange.java
 * 
 * This class provides a solution to the "Coin Change" problem using dynamic programming.
 * 
 * Problem:
 * Given an integer array `coins` representing different denominations of coins and an integer `amount` 
 * representing a total amount of money, return the fewest number of coins needed to make up that amount. 
 * If that amount cannot be made up by any combination of the coins, return -1.
 * 
 * Example:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Solution Summary:
 * - Use a dynamic programming approach to solve the problem.
 * - Create a `dp` array where `dp[i]` represents the minimum number of coins required to make up the amount `i`.
 * - Initialize `dp[0]` to 0 (base case) and all other values to `Integer.MAX_VALUE` (representing an impossible state).
 * - For each amount from 1 to `amount`, iterate through the coins array and update the `dp` array by checking 
 *   if the current coin can contribute to the solution.
 * - Return `dp[amount]` if it is not `Integer.MAX_VALUE`, otherwise return -1.
 * 
 * Notes:
 * - Time Complexity: O(amount * n), where `n` is the number of coins. For each amount, we iterate through all coins.
 * - Space Complexity: O(amount), as we use a one-dimensional array `dp` of size `amount + 1`.
 * - Edge Cases: Handle cases where `amount` is 0 (return 0), or where no combination of coins can form the amount (return -1).
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/coin-change/
 * - Video explanation: [Insert relevant video link here, e.g., YouTube tutorials on Coin Change problem]
 * 
 * Usage:
 * - This implementation can be used to solve similar problems involving minimum steps or combinations to reach a target.
 * - It is particularly useful in financial applications or games where coin denominations are involved.
 * 
 * Underlying Algorithm:
 * - Dynamic Programming: The problem is solved by breaking it into smaller subproblems and building up the solution 
 *   using previously computed results.
 * 
 * Author: [Your Name]
 * Date: [Insert Date]
 */
package dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(cc.coinChange(coins, amount)); // Output: 3
    }
}

