/**
 * EncodeAndDecodeStrings
 * 
 * Problem:
 * This class provides methods to encode a list of strings into a single string and decode it back to the original list of strings.
 * The encoding ensures that the strings can be uniquely reconstructed without ambiguity.
 * 
 * Example:
 * Input: ["Hello", "World"]
 * Encoding: "5#Hello5#World"
 * Decoding: ["Hello", "World"]
 * 
 * Solution Summary:
 * - Encoding: Each string is prefixed with its length followed by a delimiter ('#') and then the string itself.
 * - Decoding: The encoded string is parsed by reading the length of each string, extracting the substring, and repeating the process.
 * 
 * Notes:
 * - Time Complexity:
 *   - Encoding: O(n), where n is the total number of characters in all strings combined.
 *   - Decoding: O(n), where n is the length of the encoded string.
 * - Space Complexity:
 *   - Encoding: O(1) additional space (excluding the output string).
 *   - Decoding: O(m), where m is the number of strings in the decoded list.
 * 
 * Resources:
 * - For more information on string manipulation in Java, refer to the official Java documentation: 
 *   https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
 * 
 * Video Explanation:
 * - A detailed explanation of encoding and decoding strings can be found in various tutorials on YouTube. 
 *   Search for "Encode and Decode Strings LeetCode" for visual walkthroughs.
 * 
 * Usage:
 * - This class can be used in scenarios where a list of strings needs to be serialized and deserialized, 
 *   such as in network communication or file storage.
 * 
 * Underlying Algorithm:
 * - The algorithm relies on a delimiter-based approach to separate the length of each string from the string itself.
 * - During decoding, the length prefix is used to extract the exact substring, ensuring no ambiguity.
 */

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public List<String> encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return List.of(encoded.toString());
    }
    
    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            decoded.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return decoded;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings codec = new EncodeAndDecodeStrings();
        List<String> original = List.of("Hello", "World");
        List<String> encoded = codec.encode(original);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = codec.decode(encoded.get(0));
        System.out.println("Decoded: " + decoded);
    }
}


