/**
 * This class provides a solution to the "Two Sum" problem.
 * 
 * Problem:
 * Given an array of integers `nums` and an integer `target`, return the indices
 * of the two numbers such that they add up to the target. Each input would have
 * exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 * 
 * Solution Summary:
 * - Use a HashMap to store the numbers and their indices as we iterate through
 *   the array.
 * - For each number, calculate its complement (target - current number).
 * - Check if the complement exists in the HashMap. If it does, return the indices
 *   of the current number and its complement.
 * - If no solution is found by the end of the loop, throw an exception.
 * 
 * Notes:
 * - The solution has a time complexity of O(n) because we traverse the array once,
 *   and HashMap operations (put and containsKey) are O(1) on average.
 * - The space complexity is O(n) due to the storage of elements in the HashMap.
 * - The method assumes that there is exactly one solution and does not handle cases
 *   where no solution exists (other than throwing an exception).
 * 
 * Resources:
 * - Problem description on LeetCode: https://leetcode.com/problems/two-sum/
 * - HashMap documentation: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 * 
 * Video Explanation:
 * - For a detailed walkthrough of the Two Sum problem, refer to:
 *   https://www.youtube.com/watch?v=KLlXCFG5TnA
 */


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

