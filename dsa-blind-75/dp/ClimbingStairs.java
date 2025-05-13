/**
 * The ClimbingStairs class provides a solution to the "Climbing Stairs" problem,
 * a classic dynamic programming problem.
 *
 * <p>Problem:
 * You are climbing a staircase. It takes `n` steps to reach the top. Each time you can either
 * climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * <p>Example:
 * Input: n = 5
 * Output: 8
 * Explanation: There are 8 ways to climb a staircase with 5 steps:
 * 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1.
 *
 * <p>Solution Summary:
 * This problem can be solved using dynamic programming. The number of ways to climb to the nth step
 * is the sum of the ways to climb to the (n-1)th step and the (n-2)th step. This is because you can
 * reach the nth step either by taking a single step from (n-1) or by taking a double step from (n-2).
 * The solution uses an iterative approach with two variables to store the results of the last two steps,
 * optimizing space complexity.
 *
 * <p>Notes:
 * - Time Complexity: O(n), where n is the number of steps. The solution iterates through the steps once.
 * - Space Complexity: O(1), as only two variables are used to store intermediate results.
 *
 * <p>Resources:
 * - LeetCode Problem: https://leetcode.com/problems/climbing-stairs/
 * - Dynamic Programming Explanation: https://www.geeksforgeeks.org/dynamic-programming/
 *
 * <p>Video Explanation:
 * - "Climbing Stairs Problem - Dynamic Programming" by NeetCode: https://youtu.be/Y0lT9Fck7qI
 *
 * <p>Usage:
 * This class can be used to calculate the number of distinct ways to climb a staircase with `n` steps.
 * It is particularly useful in scenarios involving combinatorial problems or dynamic programming practice.
 *
 * <p>Underlying Algorithm:
 * The algorithm is based on the Fibonacci sequence, where each term is the sum of the two preceding terms.
 * The base cases are:
 * - If n = 1, there is only 1 way to climb the stairs.
 * - If n = 2, there are 2 ways to climb the stairs.
 * For n > 2, the solution iteratively calculates the number of ways using the relation:
 * ways(n) = ways(n-1) + ways(n-2).
 */
package dp;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(5)); // Output: 8
        System.out.println(cs.climbStairs(10)); // Output: 89
    }
}

