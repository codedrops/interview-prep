/**
 * This class provides a solution to the problem of counting all palindromic substrings
 * in a given string. A palindromic substring is a substring that reads the same 
 * backward as forward.
 *
 * Problem:
 * Given a string `s`, return the total number of palindromic substrings in it.
 * 
 * Example:
 * Input: s = "abc"
 * Output: 3
 * Explanation: The palindromic substrings are "a", "b", and "c".
 *
 * Solution Summary:
 * - The solution uses the concept of expanding around the center.
 * - Each character and the gap between characters are treated as potential centers.
 * - For each center, expand outward while the characters on both sides are equal.
 * - Count each valid expansion as a palindromic substring.
 *
 * Notes:
 * - Time Complexity: O(n^2), where n is the length of the string. This is because 
 *   for each of the 2n-1 centers, the expansion can take O(n) in the worst case.
 * - Space Complexity: O(1), as no additional data structures are used.
 *
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/palindromic-substrings/
 * - Video explanation: https://www.youtube.com/watch?v=4RACzI5-du8
 *
 * Usage:
 * - This algorithm can be used in scenarios where we need to analyze palindromic 
 *   properties of substrings, such as in DNA sequence analysis or text processing.
 *
 * Underlying Algorithm:
 * - The algorithm leverages the "expand around center" technique, which is efficient 
 *   for finding palindromic substrings without requiring additional space for dynamic 
 *   programming tables or preprocessing.
 */
package string;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
    
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
    
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
    
        return count;
    }
    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        String s = "abc";
        System.out.println(ps.countSubstrings(s)); // Output: 3
    }
}

