/**
 * GroupAnagrams.java
 * 
 * Problem:
 * Given an array of strings, group the anagrams together. An anagram is a word or phrase 
 * formed by rearranging the letters of a different word or phrase, typically using all 
 * the original letters exactly once.
 * 
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
 * 
 * Solution Summary:
 * - The solution uses a HashMap to group strings that are anagrams of each other.
 * - For each string in the input array, its characters are sorted to form a key.
 * - Strings with the same sorted key are grouped together in the map.
 * - Finally, the values of the map (which are lists of grouped anagrams) are returned.
 * 
 * Notes:
 * - Time Complexity: O(N * K * log(K)), where N is the number of strings in the input array 
 *   and K is the maximum length of a string. Sorting each string takes O(K * log(K)), and 
 *   this is done for all N strings.
 * - Space Complexity: O(N * K), where N is the number of strings and K is the maximum length 
 *   of a string. The space is used for the HashMap and the intermediate storage of sorted keys.
 * 
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/group-anagrams/
 * - Video explanation: https://www.youtube.com/watch?v=vzdNOK2oB2E
 * 
 * Usage:
 * - This function can be used in applications where grouping similar items is required, 
 *   such as text processing, word games, or data clustering.
 * 
 * Underlying Algorithm:
 * - The algorithm relies on sorting the characters of each string to generate a unique key 
 *   for anagrams. This ensures that all anagrams map to the same key in the HashMap.
 * 
 * Additional Notes:
 * - The solution assumes that the input strings contain only lowercase English letters.
 * - If the input contains a large number of strings or very long strings, consider optimizing 
 *   the key generation process (e.g., using character counts instead of sorting).
 */
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

        public static void main(String[] args) {
            GroupAnagrams solution = new GroupAnagrams();
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> result = solution.groupAnagrams(strs);
            System.out.println(result);
        }
}


