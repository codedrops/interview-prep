/**
 * DecodeWays - A solution to the "Decode Ways" problem.
 *
 * Problem:
 * Given a string `s` containing only digits, return the total number of ways to decode it.
 * Each digit or pair of digits can be mapped to a letter using the following mapping:
 * '1' -> 'A', '2' -> 'B', ..., '26' -> 'Z'.
 * 
 * Constraints:
 * - The input string may contain leading zeros, which are invalid for decoding.
 * - A valid decoding must map to one or more letters.
 *
 * Examples:
 * - Input: "226" -> Output: 3
 *   Explanation: "226" can be decoded as "BZ", "VF", or "BBF".
 * - Input: "12" -> Output: 2
 *   Explanation: "12" can be decoded as "AB" or "L".
 * - Input: "0" -> Output: 0
 *   Explanation: No valid decoding exists for a string starting with '0'.
 * - Input: "06" -> Output: 0
 *   Explanation: No valid decoding exists for a string starting with '0'.
 *
 * Solution Summary:
 * - This solution uses dynamic programming to calculate the number of ways to decode the string.
 * - A DP array `dp` is used where `dp[i]` represents the number of ways to decode the substring `s[0..i-1]`.
 * - Base cases:
 *   - `dp[0] = 1` (empty string has one way to decode).
 *   - `dp[1] = 1` if the first character is not '0', otherwise `dp[1] = 0`.
 * - Transition:
 *   - If the current character (oneDigit) is valid (1-9), add `dp[i-1]` to `dp[i]`.
 *   - If the last two characters (twoDigits) form a valid number (10-26), add `dp[i-2]` to `dp[i]`.
 *
 * Notes:
 * - Time Complexity: O(n), where `n` is the length of the string `s`.
 *   - Each character is processed once to compute the DP array.
 * - Space Complexity: O(n), for the DP array of size `n+1`.
 *   - Space can be optimized to O(1) by using two variables instead of a full DP array.
 *
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/decode-ways/
 * - Video Explanation: [Insert relevant video link here, e.g., YouTube tutorials]
 *
 * Usage:
 * - This solution can be used to solve problems involving decoding or mapping strings to other representations.
 * - It demonstrates the use of dynamic programming for problems with overlapping subproblems.
 *
 * Underlying Algorithm:
 * - Dynamic Programming:
 *   - Breaks the problem into smaller subproblems and uses previously computed results to build the solution.
 *   - Ensures that each subproblem is solved only once, improving efficiency.
 */


public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
    
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
    
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
    
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
    
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("226")); // Output: 3
        System.out.println(dw.numDecodings("12"));  // Output: 2
        System.out.println(dw.numDecodings("0"));   // Output: 0
        System.out.println(dw.numDecodings("06"));  // Output: 0
    }
}

