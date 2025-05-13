/**
 * This class provides a solution to the "Meeting Rooms" problem.
 * 
 * Problem:
 * Given an array of meeting time intervals where each interval is represented as [start, end],
 * determine if a person can attend all meetings. A person cannot attend two meetings that overlap.
 * 
 * Example:
 * Input: intervals = [[0, 30], [5, 10], [15, 20]]
 * Output: false
 * Explanation: The person cannot attend all meetings because the meeting [5, 10] overlaps with [0, 30].
 * 
 * Solution Summary:
 * 1. If the input intervals array is null or empty, return true (no meetings to attend).
 * 2. Sort the intervals by their start times.
 * 3. Iterate through the sorted intervals and check if the start time of the current interval
 *    is less than the end time of the previous interval. If so, return false (overlap detected).
 * 4. If no overlaps are found, return true.
 * 
 * Notes:
 * - Time Complexity: O(n log n), where n is the number of intervals. Sorting the intervals takes O(n log n),
 *   and the subsequent iteration through the intervals takes O(n).
 * - Space Complexity: O(1), as the sorting is done in-place and no additional data structures are used.
 * 
 * Resources:
 * - Problem explanation: https://leetcode.com/problems/meeting-rooms/
 * - Video explanation: Search "Meeting Rooms problem" on YouTube for visual walkthroughs.
 * 
 * Usage:
 * This class can be used to determine if a person can attend all meetings given a list of intervals.
 * It is useful in scheduling problems where overlapping intervals need to be detected.
 * 
 * Underlying Algorithm:
 * The solution uses sorting and a single pass through the intervals to detect overlaps.
 * Sorting ensures that intervals are processed in chronological order, making it easy to check for overlaps.
 */
package interval;
import java.util.Arrays;


public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
    
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
        for (int i = 1; i < intervals.length; i++) {
            // Check if there is an overlap
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
    
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(mr.canAttendMeetings(intervals)); // Output: false
    }
}


