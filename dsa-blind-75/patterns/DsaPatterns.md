# DSA Problem-Solving Patterns

## 1. Sliding Window
- **Key Idea**: Use a window (subarray or substring) that slides over the data to solve problems involving contiguous elements.
- **Complexity**: O(n) for most problems.
- **Best Video Explanation**: [Sliding Window Pattern by NeetCode](https://www.youtube.com/watch?v=MK-NZ4hN7rs)
- **Common Problems**:
    - Maximum Sum Subarray of Size K
    - Longest Substring Without Repeating Characters
    - Minimum Window Substring
- **Must Try Problem**: [Longest Substring Without Repeating Characters (LeetCode 3)](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- **How to Recognize**: Look for problems involving contiguous subarrays or substrings.
- **Underlying Algorithm**: Iterative window expansion and contraction.

---

## 2. Two Pointers
- **Key Idea**: Use two pointers to traverse the array from different directions.
- **Complexity**: O(n) for most problems.
- **Best Video Explanation**: [Two Pointers Pattern by NeetCode](https://www.youtube.com/watch?v=3OamzN90kPg)
- **Common Problems**:
    - Two Sum (Sorted Array)
    - Container With Most Water
    - 3Sum
- **Must Try Problem**: [Container With Most Water (LeetCode 11)](https://leetcode.com/problems/container-with-most-water/)
- **How to Recognize**: Problems involving pairs or triplets in sorted arrays.
- **Underlying Algorithm**: Increment or decrement pointers based on conditions.

---

## 3. Fast and Slow Pointers (Tortoise and Hare)
- **Key Idea**: Use two pointers moving at different speeds to detect cycles or find midpoints.
- **Complexity**: O(n).
- **Best Video Explanation**: [Cycle Detection by NeetCode](https://www.youtube.com/watch?v=zbozWoMgKW0)
- **Common Problems**:
    - Linked List Cycle Detection
    - Find the Duplicate Number
    - Middle of the Linked List
- **Must Try Problem**: [Linked List Cycle (LeetCode 141)](https://leetcode.com/problems/linked-list-cycle/)
- **How to Recognize**: Problems involving cycles or midpoints in linked lists.
- **Underlying Algorithm**: Floyd’s Cycle Detection Algorithm.

---

## 4. Merge Intervals
- **Key Idea**: Sort intervals and merge overlapping ones.
- **Complexity**: O(n log n) due to sorting.
- **Best Video Explanation**: [Merge Intervals by NeetCode](https://www.youtube.com/watch?v=44H3cEC2fFM)
- **Common Problems**:
    - Merge Intervals
    - Insert Interval
    - Meeting Rooms II
- **Must Try Problem**: [Merge Intervals (LeetCode 56)](https://leetcode.com/problems/merge-intervals/)
- **How to Recognize**: Problems involving overlapping intervals.
- **Underlying Algorithm**: Sorting and greedy merging.

---

## 5. Binary Search
- **Key Idea**: Divide and conquer by repeatedly halving the search space.
- **Complexity**: O(log n).
- **Best Video Explanation**: [Binary Search by NeetCode](https://www.youtube.com/watch?v=s4DPM8ct1pI)
- **Common Problems**:
    - Binary Search
    - Search in Rotated Sorted Array
    - Find Minimum in Rotated Sorted Array
- **Must Try Problem**: [Search in Rotated Sorted Array (LeetCode 33)](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- **How to Recognize**: Problems involving sorted arrays or monotonic functions.
- **Underlying Algorithm**: Divide and conquer.

---

## 6. Dynamic Programming (DP)
- **Key Idea**: Break problems into overlapping subproblems and use memoization or tabulation.
- **Complexity**: Varies (O(n), O(n^2), etc.).
- **Best Video Explanation**: [Dynamic Programming by NeetCode](https://www.youtube.com/watch?v=oBt53YbR9Kk)
- **Common Problems**:
    - Fibonacci Numbers
    - Longest Increasing Subsequence
    - Knapsack Problem
- **Must Try Problem**: [Longest Increasing Subsequence (LeetCode 300)](https://leetcode.com/problems/longest-increasing-subsequence/)
- **How to Recognize**: Problems with overlapping subproblems or optimal substructure.
- **Underlying Algorithm**: Recursion with memoization or iterative tabulation.

---

## 7. Backtracking
- **Key Idea**: Explore all possible solutions by building and abandoning partial solutions.
- **Complexity**: Exponential in the worst case.
- **Best Video Explanation**: [Backtracking by NeetCode](https://www.youtube.com/watch?v=pfiQ_PS1g8E)
- **Common Problems**:
    - N-Queens
    - Sudoku Solver
    - Permutations
- **Must Try Problem**: [N-Queens (LeetCode 51)](https://leetcode.com/problems/n-queens/)
- **How to Recognize**: Problems requiring all possible combinations or permutations.
- **Underlying Algorithm**: Depth-first search with pruning.

---

## 8. Greedy
- **Key Idea**: Make the locally optimal choice at each step.
- **Complexity**: Varies (O(n), O(n log n), etc.).
- **Best Video Explanation**: [Greedy Algorithms by NeetCode](https://www.youtube.com/watch?v=ARkl69eBzhY)
- **Common Problems**:
    - Activity Selection Problem
    - Minimum Number of Platforms
    - Huffman Encoding
- **Must Try Problem**: [Minimum Number of Platforms (GeeksforGeeks)](https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1)
- **How to Recognize**: Problems where local optimization leads to global optimization.
- **Underlying Algorithm**: Iterative greedy selection.

---

## 9. Divide and Conquer
- **Key Idea**: Divide the problem into smaller subproblems, solve them, and combine results.
- **Complexity**: Varies (O(n log n) for merge sort, etc.).
- **Best Video Explanation**: [Divide and Conquer by NeetCode](https://www.youtube.com/watch?v=7LN9Z9wH9PQ)
- **Common Problems**:
    - Merge Sort
    - Quick Sort
    - Maximum Subarray
- **Must Try Problem**: [Maximum Subarray (LeetCode 53)](https://leetcode.com/problems/maximum-subarray/)
- **How to Recognize**: Problems that can be split into independent subproblems.
- **Underlying Algorithm**: Recursive problem splitting.

---

## 10. Graph Traversal (BFS/DFS)
- **Key Idea**: Explore nodes and edges of a graph using breadth-first or depth-first search.
- **Complexity**: O(V + E) for adjacency list representation.
- **Best Video Explanation**: [Graph Traversal by NeetCode](https://www.youtube.com/watch?v=bIA8HEEUxZI)
- **Common Problems**:
    - Number of Islands
    - Word Ladder
    - Clone Graph
- **Must Try Problem**: [Number of Islands (LeetCode 200)](https://leetcode.com/problems/number-of-islands/)
- **How to Recognize**: Problems involving graphs, grids, or connectivity.
- **Underlying Algorithm**: BFS or DFS.

---

## 11. Monotonic Stack
- **Key Idea**: Use a stack to maintain elements in a monotonic order (increasing or decreasing) to solve problems involving ranges or spans.
- **Complexity**: O(n) for most problems.
- **Best Video Explanation**: [Monotonic Stack by NeetCode](https://www.youtube.com/watch?v=zx5Sw9130L0)
- **Common Problems**:
    - Largest Rectangle in Histogram
    - Trapping Rain Water
    - Daily Temperatures
- **Must Try Problem**: [Largest Rectangle in Histogram (LeetCode 84)](https://leetcode.com/problems/largest-rectangle-in-histogram/)
- **How to Recognize**: Problems involving ranges, spans, or the "next greater/smaller element."
- **Underlying Algorithm**: Use a stack to maintain a monotonic sequence and process elements efficiently.

---

## 12. Union-Find (Disjoint Set Union)
- **Key Idea**: Use a union-find data structure to group elements and efficiently check connectivity.
- **Complexity**: O(α(n)) for most operations (where α is the inverse Ackermann function).
- **Best Video Explanation**: [Union-Find by NeetCode](https://www.youtube.com/watch?v=ibjEGG7ylHk)
- **Common Problems**:
    - Number of Connected Components
    - Redundant Connection
    - Accounts Merge
- **Must Try Problem**: [Number of Connected Components in an Undirected Graph (LeetCode 323)](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
- **How to Recognize**: Problems involving connectivity or grouping in graphs.
- **Underlying Algorithm**: Union by rank and path compression.

---

## 13. Topological Sort
- **Key Idea**: Use a directed acyclic graph (DAG) to determine the order of tasks or dependencies.
- **Complexity**: O(V + E) for adjacency list representation.
- **Best Video Explanation**: [Topological Sort by NeetCode](https://www.youtube.com/watch?v=cIBFEhD77b4)
- **Common Problems**:
    - Course Schedule
    - Alien Dictionary
    - Minimum Height Trees
- **Must Try Problem**: [Course Schedule (LeetCode 207)](https://leetcode.com/problems/course-schedule/)
- **How to Recognize**: Problems involving ordering or dependencies in a DAG.
- **Underlying Algorithm**: Kahn’s Algorithm or DFS-based topological sorting.

---

## 14. Bit Manipulation
- **Key Idea**: Use bitwise operations to solve problems efficiently.
- **Complexity**: O(1) for most operations.
- **Best Video Explanation**: [Bit Manipulation by NeetCode](https://www.youtube.com/watch?v=5rtVTUu3o4Q)
- **Common Problems**:
    - Single Number
    - Subsets
    - Reverse Bits
- **Must Try Problem**: [Single Number (LeetCode 136)](https://leetcode.com/problems/single-number/)
- **How to Recognize**: Problems involving binary representation or bit-level operations.
- **Underlying Algorithm**: XOR, AND, OR, and bit shifts.

---

## 15. Trie (Prefix Tree)
- **Key Idea**: Use a tree-like data structure to store strings for efficient prefix-based operations.
- **Complexity**: O(m) for insert/search (where m is the length of the string).
- **Best Video Explanation**: [Trie by NeetCode](https://www.youtube.com/watch?v=oobqoCJlHA0)
- **Common Problems**:
    - Implement Trie
    - Word Search II
    - Replace Words
- **Must Try Problem**: [Implement Trie (LeetCode 208)](https://leetcode.com/problems/implement-trie-prefix-tree/)
- **How to Recognize**: Problems involving prefixes, autocomplete, or dictionary-like operations.
- **Underlying Algorithm**: Tree traversal and prefix matching.

---

## 16. Kadane’s Algorithm
- **Key Idea**: Use a dynamic programming approach to find the maximum sum subarray in O(n) time.
- **Complexity**: O(n).
- **Best Video Explanation**: [Kadane’s Algorithm by NeetCode](https://www.youtube.com/watch?v=86CQq3pKSUw)
- **Common Problems**:
    - Maximum Subarray
    - Maximum Circular Subarray
    - Maximum Product Subarray
- **Must Try Problem**: [Maximum Subarray (LeetCode 53)](https://leetcode.com/problems/maximum-subarray/)
- **How to Recognize**: Problems involving maximum or minimum subarray sums.
- **Underlying Algorithm**: Iterative dynamic programming.

---

## 17. Prefix Sum
- **Key Idea**: Precompute cumulative sums to solve range sum queries efficiently.
- **Complexity**: O(n) for preprocessing, O(1) for range queries.
- **Best Video Explanation**: [Prefix Sum by NeetCode](https://www.youtube.com/watch?v=wsTcByj8QbY)
- **Common Problems**:
    - Subarray Sum Equals K
    - Range Sum Query - Immutable
    - Continuous Subarray Sum
- **Must Try Problem**: [Subarray Sum Equals K (LeetCode 560)](https://leetcode.com/problems/subarray-sum-equals-k/)
- **How to Recognize**: Problems involving range sums or subarray sums.
- **Underlying Algorithm**: Use a prefix sum array or hash map for efficient lookups.

---

## 18. Matrix Traversal
- **Key Idea**: Traverse a 2D matrix using BFS, DFS, or iterative methods.
- **Complexity**: O(m * n) for most problems (where m and n are matrix dimensions).
- **Best Video Explanation**: [Matrix Traversal by NeetCode](https://www.youtube.com/watch?v=zg4c92pNFeo)
- **Common Problems**:
    - Spiral Matrix
    - Word Search
    - Rotting Oranges
- **Must Try Problem**: [Word Search (LeetCode 79)](https://leetcode.com/problems/word-search/)
- **How to Recognize**: Problems involving grids or 2D arrays.
- **Underlying Algorithm**: Iterative or recursive traversal techniques.

---

## 19. Heap (Priority Queue)
- **Key Idea**: Use a heap to efficiently retrieve the smallest or largest element.
- **Complexity**: O(log n) for insertion and extraction.
- **Best Video Explanation**: [Heap by NeetCode](https://www.youtube.com/watch?v=3DdP6Ef8YZM)
- **Common Problems**:
    - Kth Largest Element in an Array
    - Merge K Sorted Lists
    - Top K Frequent Elements
- **Must Try Problem**: [Kth Largest Element in an Array (LeetCode 215)](https://leetcode.com/problems/kth-largest-element-in-an-array/)
- **How to Recognize**: Problems involving priority or order of elements.
- **Underlying Algorithm**: Min-heap or max-heap operations.

---

## 20. Sliding Window + Hashing
- **Key Idea**: Combine sliding window with hashing to solve problems involving substrings or subarrays.
- **Complexity**: O(n) for most problems.
- **Best Video Explanation**: [Sliding Window + Hashing by NeetCode](https://www.youtube.com/watch?v=8hly31xKli0)
- **Common Problems**:
    - Longest Substring with At Most K Distinct Characters
    - Subarrays with K Different Integers
    - Permutation in String
- **Must Try Problem**: [Permutation in String (LeetCode 567)](https://leetcode.com/problems/permutation-in-string/)
- **How to Recognize**: Problems involving substrings or subarrays with specific constraints.
- **Underlying Algorithm**: Sliding window with hash map for efficient lookups.

---