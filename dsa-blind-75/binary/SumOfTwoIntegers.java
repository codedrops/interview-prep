/**
 * This class provides a method to calculate the sum of two integers without using 
 * the '+' or '-' operators. It uses bitwise operations to achieve the result.
 *
 * Problem:
 * Given two integers `a` and `b`, return their sum without using the '+' or '-' operators.
 *
 * Example:
 * - Input: a = 1, b = 2
 *   Output: 3
 * - Input: a = -2, b = 3
 *   Output: 1
 * - Input: a = 0, b = 0
 *   Output: 0
 *
 * Solution Summary:
 * - The solution uses bitwise operations to simulate addition:
 *   1. `a & b` computes the carry bits.
 *   2. `a ^ b` computes the sum without considering the carry.
 *   3. The carry is shifted left by 1 (`carry << 1`) and added to the sum in the next iteration.
 *   4. The process repeats until there is no carry left (`b == 0`).
 *
 * Notes:
 * - Time Complexity: O(n), where `n` is the number of bits in the integers. In the worst case, 
 *   the carry propagates through all the bits.
 * - Space Complexity: O(1), as the solution uses a constant amount of extra space.
 * - This approach works for both positive and negative integers due to the use of two's complement representation.
 *
 * Resources:
 * - Two's Complement Representation: https://en.wikipedia.org/wiki/Two%27s_complement
 * - Bitwise Operations in Java: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
 *
 * Video Explanation:
 * - "Sum of Two Integers Without Using '+' or '-' Operators" by NeetCode: https://youtu.be/gVUrDV4tZfY
 */
package binary;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    public static void main(String[] args) {
        SumOfTwoIntegers sum = new SumOfTwoIntegers();
        System.out.println(sum.getSum(1, 2)); // Output: 3
        System.out.println(sum.getSum(-2, 3)); // Output: 1
        System.out.println(sum.getSum(0, 0)); // Output: 0
    }
}

