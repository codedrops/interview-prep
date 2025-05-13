/**
 * MergeKSortedLists
 *
 * Problem:
 * Given an array of k linked lists, where each linked list is sorted in ascending order,
 * merge all the linked lists into one sorted linked list and return it.
 *
 * Example:
 * Input: 
 *   list1: 1 -> 4 -> 5
 *   list2: 1 -> 3 -> 4
 *   list3: 2 -> 6
 *   lists = [list1, list2, list3]
 * Output:
 *   Merged List: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
 *
 * Solution Summary:
 * - Use a PriorityQueue (min-heap) to efficiently retrieve the smallest element among the heads of the k lists.
 * - Add the head of each non-empty list to the PriorityQueue.
 * - Repeatedly extract the smallest element from the PriorityQueue, add it to the result list, and push its next node (if any) into the PriorityQueue.
 * - Continue until the PriorityQueue is empty.
 *
 * Notes:
 * - Time Complexity: O(N log k), where N is the total number of nodes across all k lists, and k is the number of lists.
 *   - Adding/removing elements from the PriorityQueue takes O(log k), and we perform this operation N times.
 * - Space Complexity: O(k), where k is the number of lists.
 *   - The PriorityQueue stores at most k elements at any time.
 *
 * Resources:
 * - Problem Explanation: https://leetcode.com/problems/merge-k-sorted-lists/
 * - Video Explanation: https://www.youtube.com/watch?v=q5a5OiGbT6Q
 *
 * Usage:
 * - This algorithm is useful for merging multiple sorted data streams, such as in external sorting or merging sorted files.
 * - It can also be applied in scenarios where you need to process data in sorted order from multiple sources.
 *
 * Underlying Algorithm:
 * - The algorithm leverages a min-heap (PriorityQueue in Java) to efficiently manage and retrieve the smallest element among the current heads of the k lists.
 * - By always extracting the smallest element and adding its next node to the heap, the algorithm ensures that the merged list is constructed in sorted order.
 */

import java.util.PriorityQueue;


public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
    
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
    
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
    
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            current.next = smallest;
            current = current.next;
    
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }
    
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        MergeKSortedLists solution = new MergeKSortedLists();
        
        ListNode list1 = solution.new ListNode(1);
        list1.next = solution.new ListNode(4);
        list1.next.next = solution.new ListNode(5);
        
        ListNode list2 = solution.new ListNode(1);
        list2.next = solution.new ListNode(3);
        list2.next.next = solution.new ListNode(4);
        
        ListNode list3 = solution.new ListNode(2);
        list3.next = solution.new ListNode(6);
        
        ListNode[] lists = {list1, list2, list3};
        
        ListNode mergedList = solution.mergeKLists(lists);
        
        // Print merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}


