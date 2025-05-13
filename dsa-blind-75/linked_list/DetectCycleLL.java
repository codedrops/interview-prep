/**
 * DetectCycleLL
 * 
 * Problem:
 * This class provides a solution to detect a cycle in a singly linked list. 
 * A cycle exists in a linked list if a node's `next` pointer points back to 
 * one of the previous nodes in the list, forming a loop.
 * 
 * Example:
 * Input: head = [1 -> 2 -> 3 -> 4 -> 5 -> points back to 1]
 * Output: true (Cycle detected)
 * 
 * Solution Summary:
 * The solution uses Floyd's Cycle Detection Algorithm (also known as the 
 * Tortoise and Hare Algorithm). Two pointers, `slow` and `fast`, traverse 
 * the list at different speeds. If there is a cycle, the two pointers will 
 * eventually meet. If there is no cycle, the `fast` pointer will reach the 
 * end of the list.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the linked list. 
 *   Both pointers traverse the list at most once.
 * - Space Complexity: O(1), as no additional data structures are used.
 * 
 * Resources:
 * - Floyd's Cycle Detection Algorithm: https://en.wikipedia.org/wiki/Cycle_detection
 * - LeetCode Problem: https://leetcode.com/problems/linked-list-cycle/
 * 
 * Video Explanation:
 * - "Detect Cycle in Linked List | Floyd's Algorithm" by NeetCode: 
 *   https://www.youtube.com/watch?v=gBTe7lFR3vc
 * 
 * Usage:
 * This class can be used to detect cycles in linked lists, which is a common 
 * problem in computer science and competitive programming. It is particularly 
 * useful in scenarios where linked lists are used to represent data structures 
 * like graphs or queues.
 * 
 * Underlying Algorithm:
 * - Floyd's Cycle Detection Algorithm:
 *   1. Initialize two pointers, `slow` and `fast`, both pointing to the head.
 *   2. Move `slow` one step at a time and `fast` two steps at a time.
 *   3. If `slow` and `fast` meet, a cycle exists.
 *   4. If `fast` reaches the end of the list, no cycle exists.
 */


public class DetectCycleLL {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
    
        ListNode slow = head;
        ListNode fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
    
            if (slow == fast) {
                return true;
            }
        }
    
        return false;
    }
    
    class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        DetectCycleLL detectCycle = new DetectCycleLL();
        ListNode head = detectCycle.new ListNode(1);
        head.next = detectCycle.new ListNode(2);
        head.next.next = detectCycle.new ListNode(3);
        head.next.next.next = detectCycle.new ListNode(4);
        head.next.next.next.next = detectCycle.new ListNode(5);
        head.next.next.next.next.next = head; // Creating a cycle

        boolean hasCycle = detectCycle.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle); // Output: Has Cycle: true
    }
}


