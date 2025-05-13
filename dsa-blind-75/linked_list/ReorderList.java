/**
 * ReorderList - A solution to reorder a singly linked list in a specific pattern.
 * 
 * Problem:
 * Given the head of a singly linked list, reorder the list such that:
 * - The first element is followed by the last element, then the second element, 
 *   followed by the second last element, and so on.
 * 
 * Example:
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 1 -> 5 -> 2 -> 4 -> 3
 * 
 * Solution Summary:
 * 1. Find the middle of the linked list using the slow and fast pointer technique.
 * 2. Reverse the second half of the linked list.
 * 3. Merge the two halves of the list in the desired order.
 * 
 * Notes:
 * - Time Complexity: O(N), where N is the number of nodes in the linked list.
 *   - Finding the middle takes O(N/2).
 *   - Reversing the second half takes O(N/2).
 *   - Merging the two halves takes O(N).
 * - Space Complexity: O(1), as the solution uses constant extra space.
 * 
 * Resources:
 * - Problem Explanation: https://leetcode.com/problems/reorder-list/
 * - Video Explanation: https://www.youtube.com/watch?v=S5bfdUTrKLM
 * 
 * Usage:
 * This method can be used to reorder linked lists in-place for problems requiring 
 * specific patterns or arrangements of nodes.
 * 
 * Underlying Algorithm:
 * - Slow and Fast Pointer Technique: To find the middle of the list efficiently.
 * - Reversal of Linked List: To reverse the second half of the list.
 * - Two-Pointer Technique: To merge the two halves in the desired order.
 * 
 * Example Usage in Main:
 * - Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
 * - Call reorderList(head)
 * - Output: 1 -> 5 -> 2 -> 4 -> 3
 */


public class ReorderList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
    
        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        // Step 2: Reverse the second half of the list
        ListNode prev = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    
        // Step 3: Merge the two halves
        ListNode first = head, second = prev;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;
    
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    public static void main(String[] args) {
        // Example usage
        ReorderList solution = new ReorderList();
        
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        
        solution.reorderList(head);
        
        // Print the modified list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

