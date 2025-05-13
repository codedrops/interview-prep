/**
 * This class provides a solution to the "Non-Overlapping Intervals" problem.
 * The goal is to find the minimum number of intervals to remove so that the 
 * remaining intervals do not overlap.
 *
 * Problem:
 * Given an array of intervals where intervals[i] = [start, end], return the 
 * minimum number of intervals you need to remove to make the rest of the 
 * intervals non-overlapping.
 *
 * Example:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: Removing the interval [1,3] leaves the rest of the intervals 
 * non-overlapping.
 *
 * Solution Summary:
 * - Sort the intervals by their end times (ascending order).
 * - Iterate through the sorted intervals and check for overlaps:
 *   - If the start time of the current interval is less than the end time of 
 *     the previous interval, it means they overlap. Increment the count of 
 *     intervals to remove.
 *   - Otherwise, update the end time to the current interval's end time.
 * - Return the count of intervals removed.
 *
 * Notes:
 * - Time Complexity: O(n log n), where n is the number of intervals. This is 
 *   due to the sorting step.
 * - Space Complexity: O(1), as the algorithm uses constant extra space.
 *
 * Resources:
 * - Problem description: https://leetcode.com/problems/non-overlapping-intervals/
 * - Video explanation: Search for "Non-Overlapping Intervals LeetCode" on 
 *   YouTube for visual walkthroughs.
 *
 * Usage:
 * - This algorithm is useful in scheduling problems where overlapping tasks 
 *   need to be minimized.
 * - Can be applied in scenarios like meeting room scheduling, resource 
 *   allocation, and timeline conflict resolution.
 *
 * Underlying Algorithm:
 * - Greedy Algorithm: The solution uses a greedy approach by always selecting 
 *   the interval with the earliest end time that does not overlap with the 
 *   previous interval. This ensures the maximum number of non-overlapping 
 *   intervals are retained.
 */

import java.util.Arrays;


public class NonOverlappinInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
    
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
    
        int count = 0;
        int prevEnd = intervals[0][1];
    
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++; // Overlapping interval, increment count
            } else {
                prevEnd = intervals[i][1]; // Update the end time
            }
        }
    
        return count;
    }
 
    public static void main(String[] args) {
        NonOverlappinInterval obj = new NonOverlappinInterval();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int result = obj.eraseOverlapIntervals(intervals);
        System.out.println("Number of intervals to remove: " + result);
    }
}
