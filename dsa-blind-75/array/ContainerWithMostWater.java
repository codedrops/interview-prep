/**
 * This class contains a solution to the "Container With Most Water" problem.
 * 
 * Problem:
 * Given an array `height` where each element represents the height of a vertical line
 * at that index, find two lines that together with the x-axis form a container, such
 * that the container contains the most water. Return the maximum amount of water a
 * container can store.
 * 
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The container formed by lines at index 1 (height 8) and index 8 (height 7)
 * has the maximum area of 49 (width = 8 - 1 = 7, height = min(8, 7) = 7, area = 7 * 7 = 49).
 * 
 * Solution Summary:
 * - Use a two-pointer approach to maximize efficiency.
 * - Start with two pointers, one at the beginning (`left`) and one at the end (`right`) of the array.
 * - Calculate the area formed by the lines at the two pointers and update the maximum area.
 * - Move the pointer pointing to the shorter line inward, as the height of the container
 *   is limited by the shorter line, and moving it inward may lead to a larger area.
 * - Repeat until the two pointers meet.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the length of the input array. Each element is processed at most once.
 * - Space Complexity: O(1), as no additional space is used apart from a few variables.
 * 
 * Resources:
 * - Problem description on LeetCode: https://leetcode.com/problems/container-with-most-water/
 * 
 * Video Explanation:
 * - "Container With Most Water - Two Pointer Approach" by NeetCode: https://www.youtube.com/watch?v=UuiTKBwPgAo
 * 
 * Usage:
 * - Instantiate the `ContainerWithMostWater` class and call the `maxArea` method with the input array.
 * - Example:
 *   ContainerWithMostWater solution = new ContainerWithMostWater();
 *   int[] height = {1,8,6,2,5,4,8,3,7};
 *   int result = solution.maxArea(height);
 *   System.out.println("Maximum Area: " + result); // Output: 49
 */



public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
    
        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * currentHeight);
    
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
    
        return maxArea;
    }
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        System.out.println("Maximum Area: " + result); // Output: 49
    }
}

