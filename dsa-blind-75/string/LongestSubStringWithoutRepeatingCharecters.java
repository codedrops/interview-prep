/**
 * This class provides a solution to the problem of finding the length of the longest
 * substring without repeating characters in a given string.
 *
 * Problem:
 * Given a string `s`, find the length of the longest substring that contains no 
 * repeating characters.
 *
 * Example:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Solution Summary:
 * - The solution uses the sliding window technique with two pointers (`left` and `right`) 
 *   to traverse the string.
 * - A fixed-size array `charIndex` of size 128 (ASCII size) is used to store the last 
 *   seen index of each character.
 * - As the `right` pointer iterates through the string, the `left` pointer is adjusted 
 *   to ensure no repeating characters exist in the current window.
 * - The length of the current substring is calculated as `right - left + 1`, and the 
 *   maximum length is updated accordingly.
 *
 * Notes:
 * - Time Complexity: O(n), where `n` is the length of the string. Each character is 
 *   processed at most twice (once by the `right` pointer and once by the `left` pointer).
 * - Space Complexity: O(1), as the `charIndex` array has a fixed size of 128, regardless 
 *   of the input size.
 *
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * - Sliding window technique: https://en.wikipedia.org/wiki/Sliding_window_technique
 *
 * Video Explanation:
 * - "Longest Substring Without Repeating Characters" by NeetCode: https://youtu.be/wiGpQwVHdE0
 *
 * Usage:
 * - This solution can be used to solve problems involving substrings with unique 
 *   characters, such as in text processing or data validation.
 *
 * Underlying Algorithm:
 * - Sliding Window: The algorithm dynamically adjusts the window size to maintain 
 *   the condition of no repeating characters, ensuring an efficient solution.
 */

public class LongestSubStringWithoutRepeatingCharecters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128]; // ASCII size
        int left = 0;
    
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            left = Math.max(charIndex[currentChar], left);
            maxLength = Math.max(maxLength, right - left + 1);
            charIndex[currentChar] = right + 1;
        }
    
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharecters solution = new LongestSubStringWithoutRepeatingCharecters();
        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}

