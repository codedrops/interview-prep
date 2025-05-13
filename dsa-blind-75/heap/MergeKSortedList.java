/**
 * MergeKSortedList
 * 
 * Problem:
 * Given an array of k linked lists, each of which is sorted in ascending order,
 * merge all the linked lists into one sorted linked list and return it.
 * 
 * Example:
 * Input: 
 * lists = [
 *   1 -> 4 -> 5,
 *   1 -> 3 -> 4,
 *   2 -> 6
 * ]
 * Output:
 * 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
 * 
 * Solution Summary:
 * - Use a Min-Heap (PriorityQueue in Java) to efficiently retrieve the smallest
 *   element among the heads of the k lists.
 * - Add the head of each list to the Min-Heap.
 * - Repeatedly extract the smallest element from the heap, add it to the result
 *   list, and push the next node of the extracted element into the heap.
 * - Continue until the heap is empty.
 * 
 * Notes:
 * - Time Complexity: O(N log k), where N is the total number of nodes across all
 *   k lists, and k is the number of linked lists. Each insertion and extraction
 *   operation in the heap takes O(log k), and there are N nodes to process.
 * - Space Complexity: O(k), where k is the number of linked lists. This is the
 *   space required to store the elements in the heap.
 * 
 * Resources:
 * - Problem Explanation: https://leetcode.com/problems/merge-k-sorted-lists/
 * - Video Explanation: https://www.youtube.com/watch?v=q5a5OiGbT6Q
 * 
 * Usage:
 * - This algorithm is useful for merging multiple sorted data streams, such as
 *   in external sorting or processing large datasets that cannot fit into memory.
 * 
 * Underlying Algorithm:
 * - The algorithm leverages a Min-Heap (PriorityQueue) to efficiently manage and
 *   retrieve the smallest element among the current heads of the k lists.
 * - The dummy node technique is used to simplify the construction of the result
 *   linked list.
 */
package heap;
import java.util.PriorityQueue;


public class MergeKSortedList {
    class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
    
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
    
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
    
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
    
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
    
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedList solution = new MergeKSortedList();
        ListNode[] lists = new ListNode[3];
        lists[0] = solution.new ListNode(1);
        lists[0].next = solution.new ListNode(4);
        lists[0].next.next = solution.new ListNode(5);
        
        lists[1] = solution.new ListNode(1);
        lists[1].next = solution.new ListNode(3);
        lists[1].next.next = solution.new ListNode(4);
        
        lists[2] = solution.new ListNode(2);
        lists[2].next = solution.new ListNode(6);
        
        ListNode mergedList = solution.mergeKLists(lists);
        
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}

