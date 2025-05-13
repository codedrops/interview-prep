/**
 * This class provides a solution to the "Contains Duplicate" problem.
 * 
 * Problem:
 * Given an integer array `nums`, return `true` if any value appears at least 
 * twice in the array, and `false` if every element is distinct.
 * 
 * Example:
 * Input: nums = [1, 2, 3, 1]
 * Output: true
 * Explanation: The number 1 appears twice in the array.
 * 
 * Solution Summary:
 * - Use a HashSet to store elements as we iterate through the array.
 * - For each element in the array:
 *   - Check if it already exists in the HashSet.
 *   - If it does, return `true` immediately (duplicate found).
 *   - Otherwise, add the element to the HashSet.
 * - If the loop completes without finding duplicates, return `false`.
 * 
 * Time Complexity:
 * - O(n): Each element is added to the HashSet once, and checking for 
 *   existence in a HashSet is O(1) on average.
 * 
 * Space Complexity:
 * - O(n): In the worst case, all elements are distinct, and the HashSet 
 *   will store all `n` elements.
 * 
 * Notes:
 * - This solution is efficient for large arrays due to the O(1) average 
 *   time complexity of HashSet operations.
 * - If the input array is sorted, an alternative approach using two 
 *   pointers could be used, but sorting would increase the time complexity 
 *   to O(n log n).
 * 
 * Resources:
 * - HashSet Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
 * - Problem on LeetCode: https://leetcode.com/problems/contains-duplicate/
 * 
 * Video Explanation:
 * - For a detailed walkthrough of this problem and solution, refer to:
 *   https://www.youtube.com/watch?v=3OamzN90kPg
 * 
 */

package array;

import java.util.HashSet;

public class ContainsDuplicate {
    
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        boolean result = solution.containsDuplicate(nums);
        System.out.println("Contains Duplicate: " + result); // Output: true
    }
}

