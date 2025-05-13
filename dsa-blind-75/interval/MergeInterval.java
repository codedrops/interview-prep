
/**
 * MergeInterval
 * 
 * Problem:
 * Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Example:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, they are merged into [1,6].
 * 
 * Solution Summary:
 * 1. Sort the intervals based on their start times.
 * 2. Use a list to store merged intervals.
 * 3. Iterate through the sorted intervals:
 *    - If the current interval overlaps with the last merged interval, merge them by updating the end time.
 *    - Otherwise, add the current interval to the list of merged intervals.
 * 4. Convert the list of merged intervals back to a 2D array and return it.
 * 
 * Notes:
 * - Time Complexity: O(n log n), where n is the number of intervals. Sorting the intervals takes O(n log n),
 *   and iterating through them takes O(n).
 * - Space Complexity: O(n), where n is the number of intervals. The merged intervals list can grow up to size n.
 * 
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/merge-intervals/
 * - Sorting in Java: https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#sort-java.lang.Object:A-java.util.Comparator-
 * 
 * Video Explanation:
 * - Merge Intervals (YouTube): https://www.youtube.com/watch?v=44H3cEC2fFM
 * 
 * Usage:
 * - This algorithm is useful in scheduling problems, where overlapping time slots need to be merged.
 * - It can also be applied in computational geometry, such as merging overlapping line segments.
 * 
 * Underlying Algorithm:
 * - Sorting: The intervals are sorted by their start times to ensure that overlapping intervals are adjacent.
 * - Greedy Approach: The algorithm iteratively merges intervals by comparing the current interval with the last merged interval.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping interval, add to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeInterval obj = new MergeInterval();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result = obj.merge(intervals);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

