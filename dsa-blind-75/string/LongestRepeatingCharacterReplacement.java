/**
 * This class provides a solution to the problem of finding the length of the longest 
 * substring containing the same letters after performing at most `k` character replacements.
 * 
 * Problem:
 * Given a string `s` and an integer `k`, you are allowed to replace at most `k` characters 
 * in the string so that the resulting substring contains only one unique character. 
 * Return the length of the longest such substring.
 * 
 * Example:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the 'B' at index 2 with 'A' to form "AAAA" or replace the 'A' at 
 * index 3 with 'B' to form "BBBB".
 * 
 * Solution Summary:
 * - The solution uses the sliding window technique to efficiently find the longest substring.
 * - A frequency array `charCount` is used to track the count of each character in the current window.
 * - The variable `maxCharCount` keeps track of the count of the most frequent character in the window.
 * - The window size is adjusted dynamically to ensure that the number of replacements required 
 *   (window size - maxCharCount) does not exceed `k`.
 * - The maximum window size encountered during the traversal is the result.
 * 
 * Notes:
 * - Time Complexity: O(n), where `n` is the length of the string. Each character is processed 
 *   at most twice (once when expanding the window and once when shrinking it).
 * - Space Complexity: O(1), as the frequency array has a fixed size of 26 (for uppercase English letters).
 * 
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/longest-repeating-character-replacement/
 * - Video explanation: https://www.youtube.com/watch?v=gqXU1UyA8pk
 * 
 * Usage:
 * - This algorithm is useful in scenarios where you need to find the longest substring 
 *   satisfying certain conditions with limited modifications.
 * - It can be adapted to solve similar problems involving sliding windows and character frequencies.
 * 
 * Underlying Algorithm:
 * - Sliding Window: The algorithm maintains a dynamic window of characters and adjusts its size 
 *   based on the constraints (number of replacements allowed).
 * - Frequency Counting: A fixed-size array is used to efficiently count character frequencies 
 *   within the window.
 */

public class LongestRepeatingCharacterReplacement {
    // Function to find the length of the longest substring with the same letters after replacement
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int maxLength = 0;
        int maxCharCount = 0;
        int left = 0;
    
        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'A']++;
            maxCharCount = Math.max(maxCharCount, charCount[s.charAt(right) - 'A']);
    
            while ((right - left + 1) - maxCharCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
    
            maxLength = Math.max(maxLength, right - left + 1);
        }
    
        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        int result = solution.characterReplacement(s, k);
        System.out.println("Length of the longest substring: " + result); // Output: 4
    }
}

