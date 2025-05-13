/**
 * WordBreak.java
 * 
 * Problem:
 * Given a string `s` and a dictionary of strings `wordDict`, determine if `s` can be segmented
 * into a space-separated sequence of one or more dictionary words. Each word in the dictionary
 * can be used multiple times.
 * 
 * Example:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: "leetcode" can be segmented as "leet code".
 * 
 * Solution Summary:
 * - This solution uses dynamic programming to solve the problem.
 * - A boolean array `dp` is used where `dp[i]` represents whether the substring `s[0:i]` can be
 *   segmented into words from the dictionary.
 * - The algorithm iterates through the string and checks all possible substrings ending at the
 *   current index. If a valid segmentation is found, the corresponding `dp` value is set to true.
 * - The final result is stored in `dp[s.length()]`.
 * 
 * Notes:
 * - Time Complexity: O(n^2), where `n` is the length of the string `s`. The outer loop runs `n`
 *   times, and the inner loop runs up to `n` times in the worst case.
 * - Space Complexity: O(n), where `n` is the length of the string `s`. The `dp` array requires
 *   `n + 1` space, and the `wordSet` requires space proportional to the size of the dictionary.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/word-break/
 * - Dynamic Programming Explanation: https://www.geeksforgeeks.org/word-break-problem-dp-32/
 * 
 * Video Explanation:
 * - "Word Break Problem | Dynamic Programming" by TechDose: https://youtu.be/Sx9NNgInc3A
 * 
 * Usage:
 * - This implementation can be used to solve problems involving string segmentation or
 *   determining if a string can be constructed using a given set of substrings.
 * 
 * Underlying Algorithm:
 * - Dynamic Programming: The problem is solved by breaking it into smaller subproblems and
 *   using previously computed results to build the solution for the larger problem.
 */
package dp;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
    
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
    
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = List.of("leet", "code");
        String s = "leetcode";
        System.out.println(wb.wordBreak(s, wordDict)); // Output: true
    }
}

