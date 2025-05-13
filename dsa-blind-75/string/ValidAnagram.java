/**
 * This class provides a solution to the "Valid Anagram" problem.
 * 
 * Problem:
 * Given two strings `s` and `t`, determine if `t` is an anagram of `s`.
 * An anagram is a word or phrase formed by rearranging the letters of a 
 * different word or phrase, using all the original letters exactly once.
 * 
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Solution Summary:
 * - Use a HashMap to count the frequency of each character in the first string `s`.
 * - Iterate through the second string `t` and decrement the frequency of each character in the map.
 * - If any character in `t` is not found in the map or its frequency becomes zero, return false.
 * - If all characters match and the map is balanced, return true.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the length of the strings. We iterate through both strings once.
 * - Space Complexity: O(1), as the HashMap will store at most 26 entries (for lowercase English letters).
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/valid-anagram/
 * - Video explanation: [Insert relevant video link here]
 * 
 * Usage:
 * - This method can be used to validate if two strings are anagrams in various applications such as 
 *   cryptography, word games, or text analysis.
 * 
 * Underlying Algorithm:
 * - HashMap-based frequency counting is used to efficiently track character occurrences.
 * - The algorithm ensures that the two strings have the same characters with the same frequencies.
 */
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
    
        HashMap<Character, Integer> countMap = new HashMap<>();
    
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
    
        for (char c : t.toCharArray()) {
            if (!countMap.containsKey(c) || countMap.get(c) == 0) {
                return false;
            }
            countMap.put(c, countMap.get(c) - 1);
        }
    
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);
        System.out.println("Is Anagram: " + result); // Output: true
    }
}

