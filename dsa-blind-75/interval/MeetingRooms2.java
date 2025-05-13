/**
 * This class provides a solution to the "Meeting Rooms II" problem.
 * 
 * Problem:
 * Given an array of meeting time intervals `intervals` where each interval is represented as 
 * [start, end], determine the minimum number of conference rooms required to hold all the meetings.
 * 
 * Example:
 * Input: intervals = [[0, 30], [5, 10], [15, 20]]
 * Output: 2
 * Explanation: Two rooms are required because the first meeting overlaps with the second, 
 * and the second overlaps with the third.
 * 
 * Solution Summary:
 * - The intervals are sorted by their start times.
 * - A min-heap (priority queue) is used to keep track of the end times of ongoing meetings.
 * - For each meeting, if the earliest ending meeting has already ended (i.e., its end time is 
 *   less than or equal to the current meeting's start time), it is removed from the heap.
 * - The current meeting's end time is added to the heap.
 * - The size of the heap at the end represents the minimum number of rooms required.
 * 
 * Notes:
 * - Time Complexity: O(n log n)
 *   - Sorting the intervals takes O(n log n).
 *   - Iterating through the intervals and maintaining the heap takes O(n log n) in total.
 * - Space Complexity: O(n)
 *   - The heap can grow to a size of n in the worst case.
 * 
 * Resources:
 * - Problem description: https://leetcode.com/problems/meeting-rooms-ii/
 * - Video explanation: https://www.youtube.com/watch?v=FdzJmTCVyJU
 * 
 * Usage:
 * - This solution can be used in scheduling problems where overlapping intervals need to be managed.
 * - Examples include booking systems, resource allocation, and event planning.
 * 
 * Underlying Algorithm:
 * - The algorithm is based on the greedy approach and uses a min-heap to efficiently track the 
 *   earliest ending meeting.
 * - By sorting the intervals and processing them in order, we ensure that we always handle the 
 *   earliest starting meeting first.
 */

import java.util.Arrays;
import java.util.PriorityQueue;


public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
    
        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    
        // Use a min heap to track the end times of meetings
        PriorityQueue<Integer> heap = new PriorityQueue<>();
    
        // Add the first meeting's end time to the heap
        heap.add(intervals[0][1]);
    
        // Iterate through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the room due to free up the earliest is free, remove it from the heap
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
            }
    
            // Add the current meeting's end time to the heap
            heap.add(intervals[i][1]);
        }
    
        // The size of the heap is the number of rooms required
        return heap.size();
    }

    public static void main(String[] args) {
        MeetingRooms2 mr = new MeetingRooms2();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(mr.minMeetingRooms(intervals)); // Output: 2
    }
}

