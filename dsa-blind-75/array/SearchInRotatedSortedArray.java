/**
 * This class provides a solution to the "Search in Rotated Sorted Array" problem.
 * 
 * Problem:
 * Given a rotated sorted array `nums` and a target value `target`, return the index of `target` if it exists in the array.
 * Otherwise, return -1. The array is rotated at some pivot unknown to you beforehand.
 * 
 * Example:
 * Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0
 * Output: 4
 * Explanation: The target value 0 is located at index 4 in the array.
 * 
 * Solution Summary:
 * - The solution uses a modified binary search algorithm to efficiently find the target.
 * - At each step, the algorithm determines whether the left or right half of the array is sorted.
 * - Depending on the sorted half, it decides whether to search in the left or right half.
 * - This ensures that the search is performed in O(log n) time complexity.
 * 
 * Notes:
 * - Time Complexity: O(log n), where n is the number of elements in the array.
 *   This is because the binary search algorithm divides the search space in half at each step.
 * - Space Complexity: O(1), as no additional data structures are used.
 * - The algorithm assumes that there are no duplicate elements in the array.
 * 
 * Resources:
 * - Problem description on LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Video Explanation:
 * - "Search in Rotated Sorted Array - Binary Search Approach" by NeetCode: https://www.youtube.com/watch?v=U8XENwh8Oy8
 * - "Binary Search in Rotated Sorted Array" by TechDose: https://www.youtube.com/watch?v=QdVrY3stDD4
 * 
 */


public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
    
            if (nums[mid] == target) {
                return mid;
            }
    
            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
    
        return -1; // Target not found
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result); // Output: Index of target 0: 4
    }
}

