/**
 * This class provides a solution to the "Minimum Window Substring" problem.
 * 
 * Problem:
 * Given two strings `s` and `t`, return the minimum window substring of `s` 
 * such that every character in `t` (including duplicates) is included in the window.
 * If there is no such substring, return an empty string.
 * 
 * Example:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The substring "BANC" contains all the characters in "ABC".
 * 
 * Solution Summary:
 * - Use the sliding window technique to dynamically adjust the window size.
 * - Maintain a frequency map of characters in `t` and track the required characters.
 * - Expand the window by moving the right pointer and shrink it by moving the left pointer
 *   when all required characters are included in the current window.
 * - Keep track of the minimum window size and its starting index.
 * 
 * Notes:
 * - Time Complexity: O(n + m), where `n` is the length of `s` and `m` is the length of `t`.
 *   This is because each character in `s` is processed at most twice (once by the right pointer
 *   and once by the left pointer).
 * - Space Complexity: O(1), as the frequency array is of fixed size (128 for ASCII characters).
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/minimum-window-substring/
 * - Video explanation: https://www.youtube.com/watch?v=jSto0O4AJbM (NeetCode)
 * 
 * Usage:
 * - This algorithm is useful in scenarios where you need to find the smallest substring
 *   containing a specific set of characters, such as in text processing or search problems.
 * 
 * Underlying Algorithm:
 * - Sliding Window Technique: Dynamically adjusts the window size to find the optimal solution.
 * - Frequency Map: Tracks the count of required characters and ensures all are included in the window.
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
    
        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }
    
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0, required = t.length();
        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (tFreq[rChar] > 0) {
                required--;
            }
            tFreq[rChar]--;
            right++;
    
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
    
                char lChar = s.charAt(left);
                tFreq[lChar]++;
                if (tFreq[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }
    
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println("Minimum window substring: " + result); // Output: "BANC"
    }
}

