/**
 * WordSearch2.java
 * 
 * Problem:
 * Given a 2D board of characters and a list of words, find all words from the list
 * that can be formed by sequentially adjacent letters on the board. Letters on the 
 * board can only be used once per word. Words must be constructed from letters 
 * adjacent horizontally or vertically.
 * 
 * Example:
 * Input:
 * board = [
 *   ['o', 'a', 'a', 'n'],
 *   ['e', 't', 'a', 'e'],
 *   ['i', 'h', 'k', 'r'],
 *   ['i', 'f', 'l', 'v']
 * ]
 * words = ["oath", "pea", "eat", "rain"]
 * Output: ["oath", "eat"]
 * 
 * Solution Summary:
 * - The solution uses a Trie (prefix tree) to efficiently store and search for words.
 * - A depth-first search (DFS) is performed on the board to explore all possible 
 *   paths for forming words.
 * - The Trie helps in pruning invalid paths early, improving efficiency.
 * - Words found are added to the result list, and duplicates are avoided by marking 
 *   the word as null in the Trie after it is found.
 * 
 * Notes:
 * - Time Complexity: O(M * 4 * 3^(L-1)), where M is the total number of cells on the board, 
 *   and L is the maximum length of a word. Each cell is visited once, and for each cell, 
 *   we explore up to 4 directions. After the first step, there are at most 3 directions 
 *   to explore for subsequent steps.
 * - Space Complexity: O(N), where N is the total number of characters in all words. This 
 *   is the space required to store the Trie.
 * 
 * Resources:
 * - Trie Data Structure: https://en.wikipedia.org/wiki/Trie
 * - Depth-First Search (DFS): https://en.wikipedia.org/wiki/Depth-first_search
 * 
 * Video Explanation:
 * - For a detailed explanation of the algorithm, refer to: 
 *   https://www.youtube.com/watch?v=asbcE9mZz_U (example video link)
 * 
 * Usage:
 * - This algorithm is useful in solving word search puzzles, crossword games, and 
 *   applications requiring efficient prefix-based word searches.
 * 
 * Underlying Algorithm:
 * - Trie: A tree-like data structure used for storing strings in a way that facilitates 
 *   efficient prefix-based searches.
 * - DFS: A graph traversal algorithm used here to explore all possible paths on the board 
 *   to form words.
 */

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate entries
        }
    
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        WordSearch2 ws = new WordSearch2();
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> result = ws.findWords(board, words);
        System.out.println(result); // Output: [eat, oath]
    }
}
