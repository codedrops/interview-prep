/**
 * This class provides a solution to the "Insert Interval" problem.
 * 
 * Problem:
 * Given a set of non-overlapping intervals sorted by their start times, insert a new interval into the intervals
 * (merge if necessary). You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example:
 * Input: intervals = [[1, 3], [6, 9]], newInterval = [2, 5]
 * Output: [[1, 5], [6, 9]]
 * 
 * Input: intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval = [4, 8]
 * Output: [[1, 2], [3, 10], [12, 16]]
 * 
 * Solution Summary:
 * 1. Traverse the intervals and add all intervals that come before the new interval to the result list.
 * 2. Merge all overlapping intervals with the new interval by updating the start and end of the new interval.
 * 3. Add the merged interval to the result list.
 * 4. Add all intervals that come after the new interval to the result list.
 * 5. Convert the result list to a 2D array and return it.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of intervals. We traverse the intervals array once.
 * - Space Complexity: O(n), where n is the number of intervals. The result list stores all intervals.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/insert-interval/
 * 
 * Video Explanation:
 * - "Insert Interval - Leetcode 57 - Python" by NeetCode: https://www.youtube.com/watch?v=A8NUOmlwOlM
 * 
 * Usage:
 * - This solution can be used in scheduling problems where intervals need to be merged after inserting a new one.
 * - It is also applicable in scenarios involving range merging or timeline adjustments.
 */

import java.util.ArrayList;
import java.util.List;


public class InsertInteval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
    
        // Add all intervals that come before the new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
    
        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
    
        // Add all intervals that come after the new interval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
    
        return result.toArray(new int[result.size()][]);
    }
     
    public static void main(String[] args) {
        InsertInteval obj = new InsertInteval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = obj.insert(intervals, newInterval);
        
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
}

