/**
 * This class provides a solution to the "Longest Palindromic Substring" problem.
 * 
 * Problem:
 * Given a string `s`, return the longest palindromic substring in `s`.
 * A palindrome is a string that reads the same backward as forward.
 * 
 * Example:
 * Input: s = "babad"
 * Output: "bab" or "aba" (both are valid answers)
 * 
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * Solution Summary:
 * - The solution uses the "Expand Around Center" approach.
 * - For each character in the string, it considers two cases:
 *   1. The palindrome has an odd length (centered at a single character).
 *   2. The palindrome has an even length (centered between two characters).
 * - It expands outward from the center(s) to find the longest palindrome for each case.
 * - The start and end indices of the longest palindrome are updated dynamically.
 * 
 * Notes:
 * - Time Complexity: O(n^2)
 *   - For each character in the string, the expansion around the center takes O(n) in the worst case.
 * - Space Complexity: O(1)
 *   - The algorithm uses a constant amount of extra space.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/longest-palindromic-substring/
 * - Video explanation: https://www.youtube.com/watch?v=XYQecbcd6_c
 * 
 * Usage:
 * - This algorithm is useful for finding the longest palindromic substring in a given string.
 * - It can be applied in text analysis, DNA sequence analysis, and other domains where palindromic patterns are relevant.
 * 
 * Underlying Algorithm:
 * - The "Expand Around Center" algorithm is used.
 * - It leverages the property of palindromes to expand outward symmetrically from a center.
 * - By iterating through all possible centers, the algorithm ensures that the longest palindrome is found.
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
    
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
    
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
    
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println("Longest Palindromic Substring of " + s + " is: " + lps.longestPalindrome(s));
    }
}

