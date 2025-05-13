/**
 * This class provides a solution to the "3Sum" problem.
 * 
 * Problem:
 * Given an integer array `nums`, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 * Explanation:
 * - The triplets [-1, -1, 2] and [-1, 0, 1] sum to 0.
 * - Notice that the output does not contain duplicate triplets.
 * 
 * Solution Summary:
 * 1. Sort the input array to simplify duplicate handling and two-pointer traversal.
 * 2. Iterate through the array, treating each element as a potential first number of the triplet.
 * 3. Use a two-pointer approach to find pairs that sum to the negative of the current element.
 * 4. Skip duplicate elements to ensure unique triplets in the result.
 * 
 * Notes:
 * - Time Complexity: O(n^2)
 *   - Sorting the array takes O(n log n).
 *   - The two-pointer traversal for each element takes O(n), resulting in O(n^2) overall.
 * - Space Complexity: O(1) (excluding the space required for the output list).
 *   - The algorithm operates in-place on the sorted array, requiring no additional space.
 * 
 * Resources:
 * - Problem Description: https://leetcode.com/problems/3sum/
 * - Two-pointer Technique: https://en.wikipedia.org/wiki/Two-pointer_technique
 * 
 * Video Explanation:
 * - "3Sum Problem Explained" by NeetCode: https://www.youtube.com/watch?v=jzZsG8n2R9A
 * 
 * Usage:
 * - Instantiate the `ThreeSum` class and call the `threeSum` method with an integer array.
 * - Example:
 *   ThreeSum solution = new ThreeSum();
 *   int[] nums = {-1, 0, 1, 2, -1, -4};
 *   List<List<Integer>> result = solution.threeSum(nums);
 *   System.out.println(result); // Outputs: [[-1, -1, 2], [-1, 0, 1]]
 * 
 */

 
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array first

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for the second and third numbers
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println("Three Sum Results: " + result);
    }
}
