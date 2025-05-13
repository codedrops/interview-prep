/**
 * ReverseLL.java
 * 
 * Problem:
 * Reverse a singly linked list. Given the head of a singly linked list, reverse the list and return its head.
 * 
 * Example:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output: 5 -> 4 -> 3 -> 2 -> 1 -> null
 * 
 * Solution Summary:
 * - The solution uses an iterative approach to reverse the linked list.
 * - It maintains three pointers: `prev` (initially null), `current` (starting at the head), and `nextTemp` (to store the next node temporarily).
 * - The `current.next` pointer is reversed to point to `prev` in each iteration.
 * - The process continues until all nodes are reversed, and the new head of the reversed list is returned.
 * 
 * Notes:
 * - Time Complexity: O(n), where n is the number of nodes in the linked list. Each node is visited exactly once.
 * - Space Complexity: O(1), as the reversal is done in-place without using any additional data structures.
 * 
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/reverse-linked-list/
 * - Video Explanation: [Insert relevant video link here, e.g., YouTube tutorials on reversing a linked list]
 * 
 * Usage:
 * - This method can be used in scenarios where reversing a linked list is required, such as in certain algorithms or data processing tasks.
 * - It is a fundamental operation in linked list manipulation and is often asked in technical interviews.
 * 
 * Underlying Algorithm:
 * - The algorithm follows an iterative approach to reverse the pointers of the linked list nodes.
 * - It ensures that the reversal is done in-place, making it efficient in terms of space usage.
 * 
 * Additional Notes:
 * - The `ListNode` class is a nested class within `ReverseLL` and represents the structure of a node in the linked list.
 * - The `main` method demonstrates the usage of the `reverseList` method by creating a sample linked list, reversing it, and printing the result.
 */


public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }
    
    class ListNode {
        int val;
        ListNode next;
    
        ListNode() {}
    
        ListNode(int val) {
            this.val = val;
        }
    
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ReverseLL reverseLL = new ReverseLL();
        ListNode head = reverseLL.new ListNode(1);
        head.next = reverseLL.new ListNode(2);
        head.next.next = reverseLL.new ListNode(3);
        head.next.next.next = reverseLL.new ListNode(4);
        head.next.next.next.next = reverseLL.new ListNode(5);

        ListNode reversedHead = reverseLL.reverseList(head);
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}


