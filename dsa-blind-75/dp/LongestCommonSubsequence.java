/**
 * This class provides a solution to the Longest Common Subsequence (LCS) problem.
 * 
 * Problem:
 * The Longest Common Subsequence problem is to find the length of the longest subsequence 
 * common to two given strings. A subsequence is a sequence derived from another sequence 
 * by deleting some or no elements without changing the order of the remaining elements.
 * 
 * Example:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The LCS is "ace", which has a length of 3.
 * 
 * Solution Summary:
 * - Use dynamic programming to solve the problem efficiently.
 * - Define a 2D DP table `dp` where `dp[i][j]` represents the length of the LCS of the 
 *   first `i` characters of `text1` and the first `j` characters of `text2`.
 * - If characters match (`text1[i-1] == text2[j-1]`), increment the LCS length by 1 
 *   from the previous diagonal value (`dp[i-1][j-1]`).
 * - If characters do not match, take the maximum value from the top (`dp[i-1][j]`) 
 *   or left (`dp[i][j-1]`) cell.
 * - The final answer is stored in `dp[m][n]`, where `m` and `n` are the lengths of 
 *   `text1` and `text2`, respectively.
 * 
 * Notes:
 * - Time Complexity: O(m * n), where `m` is the length of `text1` and `n` is the length of `text2`.
 *   This is because we iterate through all cells of the DP table.
 * - Space Complexity: O(m * n), as we use a 2D DP table to store intermediate results.
 *   Space optimization to O(min(m, n)) is possible by using a single-dimensional array.
 * 
 * Resources:
 * - Problem Explanation: https://leetcode.com/problems/longest-common-subsequence/
 * - Video Explanation: https://www.youtube.com/watch?v=Ua0GhsJSlWM
 * 
 * Usage:
 * - This algorithm can be used in various applications such as diff tools, DNA sequence 
 *   analysis, and text comparison.
 * 
 * Underlying Algorithm:
 * - Dynamic Programming: The problem is solved by breaking it into overlapping subproblems 
 *   and solving each subproblem only once, storing the results for reuse.
 */
package dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
    
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(lcs.longestCommonSubsequence(text1, text2)); // Output: 3
    }
}
