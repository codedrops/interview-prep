/**
 * This class provides a method to reverse the bits of a given 32-bit unsigned integer.
 * 
 * Problem:
 * Given a 32-bit unsigned integer `n`, reverse its bits and return the resulting integer.
 * 
 * Example:
 * Input: n = 43261596 (binary: 00000010100101000001111010011100)
 * Output: 964176192 (binary: 00111001011110000010100101000000)
 * 
 * Solution Summary:
 * - Initialize a result variable to 0.
 * - Iterate through all 32 bits of the input integer.
 * - For each bit:
 *   1. Shift the result to the left by 1 to make space for the new bit.
 *   2. Extract the least significant bit of `n` using `n & 1` and add it to the result.
 *   3. Perform an unsigned right shift on `n` to process the next bit.
 * - Return the final result after processing all bits.
 * 
 * Notes:
 * - The method uses bitwise operations to efficiently reverse the bits.
 * - The unsigned right shift operator (`>>>`) ensures that the sign bit is not propagated.
 * 
 * Time Complexity: O(1)
 * - The loop runs exactly 32 iterations, which is constant time.
 * 
 * Space Complexity: O(1)
 * - The algorithm uses a constant amount of extra space.
 * 
 * Resources:
 * - Bitwise operations: https://en.wikipedia.org/wiki/Bitwise_operation
 * - Unsigned right shift in Java: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 * 
 * Video Explanation:
 * - "Reverse Bits - LeetCode 190" by NeetCode: https://www.youtube.com/watch?v=UcoN6UjAI64
 */


public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // Shift result to the left
            result |= (n & 1); // Add the last bit of n to result
            n >>>= 1; // Unsigned right shift n
        }
        return result;
    }
    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(43261596)); // Output: 964176192
    }
}

