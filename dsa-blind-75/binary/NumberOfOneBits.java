/**
 * NumberOfOneBits
 *
 * Problem:
 * Given an unsigned integer, write a function to return the number of '1' bits it has 
 * (also known as the Hamming weight).
 *
 * Examples:
 * 1. Input: n = 11 (binary: 1011)
 *    Output: 3
 * 2. Input: n = 128 (binary: 10000000)
 *    Output: 1
 * 3. Input: n = -3 (binary representation in 32-bit: 11111111111111111111111111111101)
 *    Output: 31
 *
 * Solution Summary:
 * - Use a loop to iterate through all bits of the integer.
 * - Use the bitwise AND operation (n & 1) to check if the least significant bit is 1.
 * - Increment the count if the least significant bit is 1.
 * - Perform an unsigned right shift (n >>>= 1) to move to the next bit.
 * - Repeat until all bits are processed (n becomes 0).
 *
 * Notes:
 * - This approach works for both positive and negative integers due to the use of 
 *   unsigned right shift (>>>), which fills the leftmost bit with 0.
 * - The function assumes a 32-bit integer representation.
 *
 * Time Complexity:
 * - O(1): The loop runs a maximum of 32 iterations (constant time) for a 32-bit integer.
 *
 * Space Complexity:
 * - O(1): No additional space is used apart from a few variables.
 *
 * Resources:
 * - Bitwise operations in Java: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 *
 * Video Explanation:
 * - Hamming Weight Explanation: https://www.youtube.com/watch?v=5Km3utixwZs
 */
package binary;

public class NumberOfOneBits {
    // Function to count the number of 1 bits in an unsigned integer
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1; // Unsigned right shift
        }
        return count;
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println(hammingWeight(11)); // Output: 3 (binary: 1011)
        System.out.println(hammingWeight(128)); // Output: 1 (binary: 10000000)
        System.out.println(hammingWeight(-3)); // Output: 31 (binary:
    }
}

