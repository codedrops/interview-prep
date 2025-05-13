/**
 * This class provides solutions to merge two sorted linked lists into one sorted linked list.
 * It includes both recursive and iterative approaches.
 *
 * Problem:
 * Given two sorted linked lists, merge them into a single sorted linked list.
 * The merged list should be made by splicing together the nodes of the two lists.
 *
 * Example:
 * Input: list1 = [1, 2, 4], list2 = [1, 3, 4]
 * Output: [1, 1, 2, 3, 4, 4]
 *
 * Solution Summary:
 * - Recursive Approach:
 *   Compare the head nodes of both lists. Recursively merge the remaining nodes of the list
 *   with the smaller head node.
 * - Iterative Approach:
 *   Use a dummy node to build the merged list iteratively by comparing the current nodes
 *   of both lists and appending the smaller node to the result.
 *
 * Notes:
 * - Time Complexity:
 *   Both approaches have a time complexity of O(n + m), where n and m are the lengths of the two lists.
 * - Space Complexity:
 *   Recursive approach: O(n + m) due to the recursion stack.
 *   Iterative approach: O(1) as it uses constant extra space.
 *
 * Resources:
 * - LeetCode Problem: https://leetcode.com/problems/merge-two-sorted-lists/
 * - Video Explanation: https://www.youtube.com/watch?v=XIdigk956u0
 *
 * Usage:
 * - Use the `mergeTwoLists` method for a recursive solution.
 * - Use the `mergeTwoListsIterative` method for an iterative solution.
 *
 * Underlying Algorithm:
 * - Both approaches rely on the two-pointer technique to traverse the two lists and merge them.
 * - The recursive approach uses the call stack to handle the merging, while the iterative approach
 *   uses a dummy node and a pointer to build the merged list.
 */


public class MergeTwoSortedLists {
    
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
    
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
    
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
    
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
    
        return dummy.next;
    }
}

