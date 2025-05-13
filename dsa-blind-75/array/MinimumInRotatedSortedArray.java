/**
 * This class provides a solution to the "Find Minimum in Rotated Sorted Array" problem.
 * 
 * Problem:
 * Given a rotated sorted array of unique integers, find the minimum element.
 * The array is sorted in ascending order, but it has been rotated at some pivot.
 * 
 * Example:
 * Input: nums = [3, 4, 5, 1, 2]
 * Output: 1
 * Explanation: The original sorted array was [1, 2, 3, 4, 5]. After rotation, it became [3, 4, 5, 1, 2].
 * 
 * Solution Summary:
 * - The solution uses a binary search approach to efficiently find the minimum element.
 * - The key observation is that the minimum element is the only element where the previous
 *   element is greater than it (or it is the first element in the array).
 * - By comparing the middle element with the rightmost element, we can determine whether
 *   the minimum lies in the left or right half of the array.
 * - The algorithm adjusts the search range (left and right pointers) accordingly until
 *   the minimum element is found.
 * 
 * Notes:
 * - Time Complexity: O(log n), where n is the size of the input array. This is due to the binary search.
 * - Space Complexity: O(1), as no additional space is used apart from a few variables.
 * 
 * Resources:
 * - Problem description on LeetCode: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Video Explanation:
 * - "Find Minimum in Rotated Sorted Array - Binary Search Approach" by NeetCode: https://youtu.be/nIVW4P8b1VA
 * 
 * Usage:
 * - Instantiate the `MinimumInRotatedSortedArray` class and call the `findMin` method
 *   with the rotated sorted array as input to get the minimum element.
 */
package array;

public class MinimumInRotatedSortedArray {
    
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
    
        while (left < right) {
            int mid = left + (right - left) / 2;
    
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    
        return nums[left];
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray solution = new MinimumInRotatedSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        int result = solution.findMin(nums);
        System.out.println("The minimum element is: " + result);
    }

}

