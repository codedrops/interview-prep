/**
 * ImplementTriePrefixTree.java
 * 
 * Problem:
 * This class implements a Trie (Prefix Tree), a data structure commonly used for efficient 
 * storage and retrieval of strings, particularly useful for prefix-based operations. 
 * The Trie supports three main operations:
 * 1. insert(String word): Inserts a word into the Trie.
 * 2. search(String word): Checks if a word exists in the Trie.
 * 3. startsWith(String prefix): Checks if there is any word in the Trie that starts with a given prefix.
 * 
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * 
 * Solution Summary:
 * - The Trie is implemented using a nested TrieNode class, where each node contains an array of 
 *   child nodes (links) representing the 26 lowercase English letters.
 * - Each TrieNode supports operations to check if a character exists, retrieve a child node, 
 *   add a child node, and mark the end of a word.
 * - The Trie class provides methods to insert words, search for exact matches, and check for prefixes.
 * 
 * Notes:
 * - Time Complexity:
 *   - insert(String word): O(L), where L is the length of the word being inserted.
 *   - search(String word): O(L), where L is the length of the word being searched.
 *   - startsWith(String prefix): O(L), where L is the length of the prefix.
 * - Space Complexity:
 *   - The space complexity is O(AL), where A is the alphabet size (26 for lowercase English letters) 
 *     and L is the total number of characters in all inserted words.
 * 
 * Resources:
 * - Trie Data Structure: https://en.wikipedia.org/wiki/Trie
 * - Video Explanation: "Trie Data Structure" by Abdul Bari on YouTube.
 * 
 * Usage:
 * - Autocomplete systems (e.g., search engines, text editors).
 * - Spell checkers.
 * - IP routing (Longest Prefix Matching).
 * - Word games like Boggle or Scrabble.
 * 
 * Underlying Algorithm:
 * - The Trie is a tree-based data structure where each node represents a single character.
 * - Words are stored as paths from the root to a node marked as the end of a word.
 * - Prefix-based operations are efficient because they traverse only the relevant portion of the tree.
 */


public class ImplementTriePrefixTree {
    
    class Trie {
    
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        public void insert(String word) {
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
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }
    
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }
    
        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else {
                    return null;
                }
            }
            return node;
        }
    
        private class TrieNode {
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
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree trie = new ImplementTriePrefixTree();
        Trie t = trie.new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));   // returns true
        System.out.println(t.search("app"));     // returns false
        System.out.println(t.startsWith("app")); // returns true
        t.insert("app");
        System.out.println(t.search("app"));     // returns true
    }
}

