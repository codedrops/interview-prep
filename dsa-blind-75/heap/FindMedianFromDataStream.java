/**
 * This class provides a solution to the problem of finding the median from a data stream.
 * 
 * Problem:
 * - The task is to design a data structure that supports adding numbers to a data stream
 *   and finding the median of all elements added so far.
 * - The median is the middle value in an ordered integer list. If the size of the list is even,
 *   the median is the average of the two middle values.
 * 
 * Example:
 * - Input: [1, 2, 3, 4, 5]
 * - Output: After each addition:
 *   - Add 1: Median = 1
 *   - Add 2: Median = 1.5
 *   - Add 3: Median = 2
 *   - Add 4: Median = 2.5
 *   - Add 5: Median = 3
 * 
 * Solution Summary:
 * - The solution uses two heaps:
 *   1. A max-heap (`lowerHalf`) to store the smaller half of the numbers.
 *   2. A min-heap (`upperHalf`) to store the larger half of the numbers.
 * - When a new number is added:
 *   - It is placed in the appropriate heap based on its value.
 *   - The heaps are balanced to ensure that the size difference between them is at most 1.
 * - The median is calculated based on the top elements of the heaps:
 *   - If the heaps are of equal size, the median is the average of the two top elements.
 *   - Otherwise, the median is the top element of the larger heap.
 * 
 * Notes:
 * - Time Complexity:
 *   - `addNum(int num)`: O(log n), where n is the number of elements in the data stream.
 *     This is due to the insertion operation in the heaps.
 *   - `findMedian()`: O(1), as it only involves accessing the top elements of the heaps.
 * - Space Complexity: O(n), where n is the number of elements in the data stream.
 *   This is due to the storage of elements in the two heaps.
 * 
 * Resources:
 * - PriorityQueue in Java: https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
 * - Median of a Data Stream (LeetCode Problem): https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Video Explanation:
 * - "Median of a Data Stream | LeetCode 295" by NeetCode: https://www.youtube.com/watch?v=itmhHWaHupI
 * 
 * Usage:
 * - This class can be used in scenarios where real-time median calculation is required,
 *   such as in financial data analysis, sensor data processing, or streaming applications.
 * 
 * Underlying Algorithm:
 * - The solution leverages the properties of heaps (priority queues) to efficiently
 *   maintain the order of elements and calculate the median in logarithmic time.
 * - The max-heap ensures that the largest element of the smaller half is easily accessible,
 *   while the min-heap ensures that the smallest element of the larger half is easily accessible.
 */
package heap;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
        private PriorityQueue<Integer> lowerHalf; // Max-Heap
        private PriorityQueue<Integer> upperHalf; // Min-Heap
    
        public MedianFinder() {
            lowerHalf = new PriorityQueue<>((a, b) -> b - a);
            upperHalf = new PriorityQueue<>();
        }
    
        public void addNum(int num) {
            if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
                lowerHalf.offer(num);
            } else {
                upperHalf.offer(num);
            }
    
            // Balance the heaps
            if (lowerHalf.size() > upperHalf.size() + 1) {
                upperHalf.offer(lowerHalf.poll());
            } else if (upperHalf.size() > lowerHalf.size()) {
                lowerHalf.offer(upperHalf.poll());
            }
        }
    
        public double findMedian() {
            if (lowerHalf.size() == upperHalf.size()) {
                return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
            } else {
                return lowerHalf.peek();
            }
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream solution = new FindMedianFromDataStream();
        MedianFinder medianFinder = solution.new MedianFinder();
        
        int[] nums = {1, 2, 3, 4, 5};
        for (int num : nums) {
            medianFinder.addNum(num);
            System.out.println("Added: " + num + ", Current Median: " + medianFinder.findMedian());
        }
    }
}

