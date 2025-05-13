/**
 * This Java program implements a data structure called `WordDictionary` using a Trie (prefix tree).
 * It supports adding words and searching for words, including support for wildcard searches using '.'.
 * 
 * Problem:
 * - Design a data structure that supports adding words and searching for words with optional wildcards.
 * - Wildcard '.' can match any single character.
 * 
 * Example:
 * - Add words: "bad", "dad", "mad"
 * - Search queries:
 *   - search("pad") -> false (word not found)
 *   - search("bad") -> true (word found)
 *   - search(".ad") -> true (wildcard matches "bad", "dad", or "mad")
 *   - search("b..") -> true (wildcard matches "bad")
 * 
 * Solution Summary:
 * - The `WordDictionary` class uses a TrieNode structure to store words.
 * - Each TrieNode contains an array of 26 links (for lowercase English letters) and a flag to indicate the end of a word.
 * - The `addWord` method inserts a word into the Trie character by character.
 * - The `search` method supports exact and wildcard searches by recursively traversing the Trie.
 * 
 * Notes:
 * - Time Complexity:
 *   - `addWord`: O(L), where L is the length of the word being added.
 *   - `search`: O(N * 26^M), where N is the length of the word being searched, and M is the number of wildcards (worst case).
 * - Space Complexity:
 *   - O(N * L), where N is the number of words added, and L is the average length of the words.
 *   - Each TrieNode requires space for 26 links and a boolean flag.
 * 
 * Resources:
 * - Trie Data Structure: https://en.wikipedia.org/wiki/Trie
 * - LeetCode Problem: https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * 
 * Video Explanation:
 * - "Trie Data Structure" by Abdul Bari: https://www.youtube.com/watch?v=AXjmTQ8LEoI
 * - "Add and Search Word" LeetCode Solution: https://www.youtube.com/watch?v=BTf05gs_8iU
 * 
 * Usage:
 * - This implementation is useful for applications like autocomplete, spell checking, and word games.
 * - It can also be extended to support case-insensitive searches or additional character sets.
 * 
 * Underlying Algorithm:
 * - The Trie data structure is used to efficiently store and retrieve strings.
 * - Wildcard searches are implemented using recursive backtracking to explore all possible matches.
 */
package tree;

public class AadAndSearchWords {
    
    class WordDictionary {
        private TrieNode root;
    
        public WordDictionary() {
            root = new TrieNode();
        }
    
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }
    
        public boolean search(String word) {
            return searchInNode(word, root);
        }
    
        private boolean searchInNode(String word, TrieNode node) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (char x = 'a'; x <= 'z'; x++) {
                        if (node.containsKey(x) && searchInNode(word.substring(i + 1), node.get(x))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    if (!node.containsKey(c)) {
                        return false;
                    }
                    node = node.get(c);
                }
            }
            return node.isEnd();
        }
    }
    
    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
    
        public TrieNode() {
            links = new TrieNode[R];
        }
    
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
    
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
    
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
    
        public void setEnd() {
            isEnd = true;
        }
    
        public boolean isEnd() {
            return isEnd;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new AadAndSearchWords().new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }
}


