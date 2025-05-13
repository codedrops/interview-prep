/**
 * This class provides a solution to the "Top K Frequent Elements" problem.
 * 
 * Problem:
 * Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.
 * You may return the answer in any order.
 * 
 * Example:
 * Input: nums = [1, 1, 1, 2, 2, 3], k = 2
 * Output: [1, 2]
 * Explanation: The numbers 1 and 2 are the two most frequent elements in the array.
 * 
 * Solution Summary:
 * 1. Use a HashMap to count the frequency of each element in the array.
 * 2. Use a Min-Heap (PriorityQueue) to keep track of the top `k` frequent elements.
 *    - The heap stores entries from the frequency map, ordered by frequency.
 *    - If the heap size exceeds `k`, remove the least frequent element.
 * 3. Extract the elements from the heap to form the result array.
 * 
 * Notes:
 * - Time Complexity: 
 *   - Building the frequency map takes O(n), where `n` is the length of the input array.
 *   - Adding elements to the heap takes O(n log k), as we process `n` elements and the heap size is limited to `k`.
 *   - Extracting elements from the heap takes O(k log k).
 *   - Overall: O(n log k).
 * - Space Complexity:
 *   - The frequency map uses O(n) space.
 *   - The heap uses O(k) space.
 *   - Overall: O(n + k).
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/top-k-frequent-elements/
 * - Video explanation: https://www.youtube.com/watch?v=YPTqKIgVk-k
 * 
 * Usage:
 * - This algorithm is useful for finding the most frequent elements in a dataset, such as analyzing word frequencies in a document.
 * - It can also be applied in recommendation systems, log analysis, and other scenarios where frequency-based ranking is required.
 * 
 * Underlying Algorithm:
 * - The solution leverages a combination of a HashMap for frequency counting and a Min-Heap for efficiently maintaining the top `k` elements.
 * - The Min-Heap ensures that the least frequent element is removed when the size exceeds `k`, keeping the most frequent elements in the heap.
 */
package heap;
import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
    
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
    
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
    
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
    }
}
