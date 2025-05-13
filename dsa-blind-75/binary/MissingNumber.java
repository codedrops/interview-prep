/**
 * This class provides a solution to the "Missing Number" problem.
 * 
 * Problem:
 * Given an array `nums` containing `n` distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 * 
 * Example:
 * Input: nums = [3, 0, 1]
 * Output: 2
 * Explanation: The range is [0, 3], and 2 is the missing number.
 * 
 * Solution Summary:
 * - The sum of the first `n` natural numbers can be calculated using the formula:
 *   `expectedSum = n * (n + 1) / 2`.
 * - Calculate the actual sum of the elements in the array.
 * - The missing number is the difference between the expected sum and the actual sum.
 * 
 * Notes:
 * - Time Complexity: O(n), where `n` is the size of the input array. This is because we iterate 
 *   through the array once to calculate the actual sum.
 * - Space Complexity: O(1), as we use a constant amount of extra space.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/missing-number/
 * 
 * Video Explanation:
 * - For a detailed explanation of the problem and solution, refer to:
 *   https://www.youtube.com/watch?v=WnPLSRLSANE
 * 
 */


public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] nums = {3, 0, 1}; // Example input
        int missing = mn.missingNumber(nums);
        System.out.println("Missing number: " + missing);
    }
}

