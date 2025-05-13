/**
 * This class provides a method to determine if a given string is a valid palindrome.
 * A valid palindrome is a string that reads the same backward as forward, ignoring
 * non-alphanumeric characters and case sensitivity.
 *
 * Problem:
 * Given a string `s`, determine if it is a palindrome considering only alphanumeric
 * characters and ignoring cases.
 *
 * Examples:
 * 1. Input: "A man, a plan, a canal: Panama"
 *    Output: true
 *    Explanation: After removing non-alphanumeric characters and converting to lowercase,
 *                 the string becomes "amanaplanacanalpanama", which is a palindrome.
 * 
 * 2. Input: "race a car"
 *    Output: false
 *    Explanation: After removing non-alphanumeric characters and converting to lowercase,
 *                 the string becomes "raceacar", which is not a palindrome.
 * 
 * 3. Input: ""
 *    Output: true
 *    Explanation: An empty string is considered a valid palindrome.
 * 
 * 4. Input: " "
 *    Output: true
 *    Explanation: A string with only spaces is considered a valid palindrome.
 *
 * Solution Summary:
 * - Use two pointers (`left` and `right`) to traverse the string from both ends.
 * - Skip non-alphanumeric characters using `Character.isLetterOrDigit`.
 * - Compare characters at the `left` and `right` pointers after converting them to lowercase.
 * - If any mismatch is found, return false. Otherwise, continue until the pointers meet.
 * - Return true if no mismatches are found.
 *
 * Notes:
 * - Time Complexity: O(n), where `n` is the length of the string. Each character is processed
 *   at most once as the two pointers traverse the string.
 * - Space Complexity: O(1), as the algorithm uses a constant amount of extra space.
 *
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/valid-palindrome/
 * - Video explanation: [Insert relevant video link here, e.g., YouTube tutorials]
 *
 * Usage:
 * - This method can be used to validate palindromic strings in applications such as
 *   text processing, natural language processing, and data validation.
 *
 * Underlying Algorithm:
 * - Two-pointer technique is used to efficiently check for palindrome properties
 *   while skipping non-alphanumeric characters.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Is \"" + test1 + "\" a palindrome? " + vp.isPalindrome(test1));
        
        String test2 = "race a car";
        System.out.println("Is \"" + test2 + "\" a palindrome? " + vp.isPalindrome(test2));
        
        String test3 = "";
        System.out.println("Is \"" + test3 + "\" a palindrome? " + vp.isPalindrome(test3));
        
        String test4 = " ";
        System.out.println("Is \"" + test4 + "\" a palindrome? " + vp.isPalindrome(test4));
    }
}

