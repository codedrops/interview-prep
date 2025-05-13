/**
 * This class provides a solution to the "Longest Consecutive Sequence" problem.
 * 
 * Problem:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * The sequence must be consecutive integers, and the order of elements in the array does not matter.
 * 
 * Example:
 * Input: nums = [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive sequence is [1, 2, 3, 4]. Its length is 4.
 * 
 * Solution Summary:
 * - Use a HashSet to store all unique elements from the input array.
 * - Iterate through the HashSet and for each number, check if it is the start of a sequence (i.e., num - 1 is not in the set).
 * - If it is the start of a sequence, count the length of the sequence by checking consecutive numbers (num + 1, num + 2, etc.).
 * - Keep track of the maximum sequence length encountered.
 * - Return the maximum sequence length.
 * 
 * Notes:
 * - Time Complexity: O(n)
 *   - Adding elements to the HashSet takes O(n).
 *   - Iterating through the HashSet and checking for consecutive elements also takes O(n) in total.
 * - Space Complexity: O(n)
 *   - The HashSet requires O(n) space to store the unique elements of the input array.
 * 
 * Resources:
 * - Problem description on LeetCode: https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Video Explanation:
 * - NeetCode: https://www.youtube.com/watch?v=P6RZZMu_maU
 * - TechDose: https://www.youtube.com/watch?v=rc2QdQ7U78I
 */

import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
    
        int longestStreak = 0;
    
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
    
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
    
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
    
        return longestStreak;
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums)); // Output: 4
    }
}

