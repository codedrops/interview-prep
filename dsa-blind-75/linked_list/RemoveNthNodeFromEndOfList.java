/**
 * This class provides a solution to the problem of removing the nth node from the end of a singly linked list.
 * 
 * Problem:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Example:
 * Input: head = [1, 2, 3, 4, 5], n = 2
 * Output: [1, 2, 3, 5]
 * Explanation: The 2nd node from the end (node with value 4) is removed.
 * 
 * Solution Summary:
 * - Use a two-pointer approach with a dummy node to simplify edge cases (e.g., removing the head).
 * - Move the first pointer `n+1` steps ahead to maintain a gap of `n` nodes between the first and second pointers.
 * - Move both pointers one step at a time until the first pointer reaches the end of the list.
 * - Adjust the `next` pointer of the second pointer to skip the nth node from the end.
 * 
 * Notes:
 * - Time Complexity: O(L), where L is the length of the linked list. The list is traversed once.
 * - Space Complexity: O(1), as no additional data structures are used.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * - Video Explanation: [Insert relevant video link, e.g., YouTube tutorials]
 * 
 * Usage:
 * - This method is useful in scenarios where you need to efficiently remove a node from the end of a linked list.
 * - It can be applied in various linked list manipulation problems.
 * 
 * Underlying Algorithm:
 * - Two-pointer technique: This approach ensures that the nth node from the end can be identified in a single traversal.
 * - Dummy node: Simplifies edge cases, such as when the head node needs to be removed.
 * 
 * Example Usage in Main:
 * - Create a linked list with nodes [1, 2, 3, 4, 5].
 * - Call `removeNthFromEnd` with `n = 2` to remove the 2nd node from the end.
 * - Print the modified list to verify the result.
 */


public class RemoveNthNodeFromEndOfList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
    
        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
    
        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
    
        // Remove the nth node from the end
        second.next = second.next.next;
    
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        
        int n = 2; // Remove the 2nd node from the end
        
        ListNode newHead = solution.removeNthFromEnd(head, n);
        
        // Print the modified list
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}

