/**
 * Jump Game Problem:
 * -------------------
 * You are given an integer array `nums` where each element represents your maximum jump length at that position.
 * Your goal is to determine if you can reach the last index starting from the first index.
 *
 * Problem Constraints:
 * - You can only jump within the bounds of the array.
 * - If at any point you cannot move forward, you fail to reach the last index.
 *
 * Example:
 * --------
 * Input: nums = [2, 3, 1, 1, 4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: nums = [3, 2, 1, 0, 4]
 * Output: false
 * Explanation: You will always stop at index 3 because its maximum jump length is 0.
 *
 * Solution Summary:
 * -----------------
 * - Use a greedy approach to track the farthest index that can be reached (`maxReach`).
 * - Iterate through the array and update `maxReach` as the maximum of its current value and `i + nums[i]`.
 * - If at any point the current index `i` exceeds `maxReach`, return false as it is not possible to proceed further.
 * - If the loop completes, return true as the last index is reachable.
 *
 * Notes:
 * ------
 * - Time Complexity: O(n), where n is the length of the array. We iterate through the array once.
 * - Space Complexity: O(1), as no additional space is used apart from a few variables.
 *
 * Resources:
 * ----------
 * - Problem Explanation: https://leetcode.com/problems/jump-game/
 * - Video Explanation: https://www.youtube.com/watch?v=Yan0cv2cLy8
 *
 * Usage:
 * ------
 * - This algorithm can be used in scenarios where you need to determine reachability in a linear system.
 * - It is particularly useful in game development or pathfinding problems.
 *
 * Underlying Algorithm:
 * ----------------------
 * - Greedy Algorithm: At each step, make the locally optimal choice of jumping as far as possible.
 * - The greedy approach ensures that we minimize unnecessary computations and achieve an efficient solution.
 */


public class JumpGame {
    
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(jg.canJump(nums1)); // Output: true
        System.out.println(jg.canJump(nums2)); // Output: false
    }
}

