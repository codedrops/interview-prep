/**
 * The CountingBits class provides a method to calculate the number of 1 bits (also known as Hamming weight or population count)
 * in the binary representation of all numbers from 0 to a given integer n.
 *
 * Problem:
 * Given a non-negative integer n, return an array where the i-th element is the number of 1 bits in the binary representation of i.
 *
 * Example:
 * Input: n = 5
 * Output: [0, 1, 1, 2, 1, 2]
 * Explanation:
 * - 0 in binary is 0 -> 0 one-bits
 * - 1 in binary is 1 -> 1 one-bit
 * - 2 in binary is 10 -> 1 one-bit
 * - 3 in binary is 11 -> 2 one-bits
 * - 4 in binary is 100 -> 1 one-bit
 * - 5 in binary is 101 -> 2 one-bits
 *
 * Solution Summary:
 * - Use dynamic programming to calculate the number of 1 bits for each number from 0 to n.
 * - The key observation is that the number of 1 bits in a number i can be derived from:
 *   result[i] = result[i >> 1] + (i & 1)
 *   - `i >> 1` shifts the bits of i to the right by 1, effectively dividing i by 2.
 *   - `(i & 1)` checks whether the least significant bit of i is 1 (i.e., whether i is odd).
 * - Start with an array initialized to 0 and iterate from 1 to n to fill the array.
 *
 * Notes:
 * - Time Complexity: O(n)
 *   - Each number from 1 to n is processed once, and the computation for each number is O(1).
 * - Space Complexity: O(n)
 *   - The result array requires O(n) space to store the number of 1 bits for each number from 0 to n.
 *
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/counting-bits/
 * - Explanation of Hamming Weight: https://en.wikipedia.org/wiki/Hamming_weight
 *
 * Video Explanation:
 * - "Counting Bits - LeetCode 338 - Python, Java, C++" by NeetCode: https://www.youtube.com/watch?v=RyBM56RIWrM
 * 
 */
package binary;

public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        int n = 5; // Example input
        int[] result = cb.countBits(n);
        for (int i = 0; i <= n; i++) {
            System.out.println("Number of 1 bits in " + i + ": " + result[i]);
        }
    }

}
