/**
 * ValidParentheses.java
 * 
 * Problem:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid. An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 
 * Example:
 * Input: s = "{[()]}"
 * Output: true
 * Explanation: All brackets are properly closed and nested.
 * 
 * Input: s = "{[(])}"
 * Output: false
 * Explanation: The brackets are not closed in the correct order.
 * 
 * Solution Summary:
 * - Use a stack to keep track of opening brackets.
 * - Traverse the string character by character:
 *   - Push opening brackets onto the stack.
 *   - For closing brackets, check if the stack is empty or if the top of the stack 
 *     does not match the corresponding opening bracket. If so, return false.
 *   - Otherwise, pop the top of the stack.
 * - After traversal, if the stack is empty, the string is valid; otherwise, it is invalid.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the length of the string. Each character is processed once.
 * - Space Complexity: O(n), in the worst case, the stack can hold all opening brackets.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/valid-parentheses/
 * - Stack Data Structure: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 * 
 * Video Explanation:
 * - "Valid Parentheses Problem Explained" on YouTube: https://www.youtube.com/watch?v=WTzjTskDFMg
 * 
 * Usage:
 * - This algorithm can be used to validate expressions in programming languages, 
 *   mathematical expressions, or any scenario requiring balanced delimiters.
 * 
 * Underlying Algorithm:
 * - The algorithm leverages the stack data structure to ensure Last-In-First-Out (LIFO) 
 *   behavior, which is ideal for matching nested structures like parentheses.
 */
package string;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

        public static void main(String[] args) {
            ValidParentheses solution = new ValidParentheses();
            String s = "{[()]}";
            boolean result = solution.isValid(s);
            System.out.println(result); // Output: true
        }
}

