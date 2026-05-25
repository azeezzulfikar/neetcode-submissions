/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // using slow fast pointers get to the mid of the list O(n)
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // at mid, separate the list.
        if(slow == fast) return;
        
        
        // reverse the second half o(n)
        ListNode prev = null, curr = slow.next;
        slow.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // merge one after the other from the 2 lists o(n)
        while(head != null && prev != null) {
            ListNode headNext = head.next;
            ListNode prevNext = prev.next;
            head.next = prev;
            prev.next = headNext;
            head = headNext;
            prev = prevNext;
        }
    }
}