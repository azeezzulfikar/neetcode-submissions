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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode();
        ListNode curr = res;
        while(l1 != null && l2 != null) {
            curr.next = new ListNode();
            curr = curr.next;
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            int leftover = sum%10;
            curr.val = leftover;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            curr.next = new ListNode();
            curr = curr.next;
            int sum = carry + l1.val;
            carry = sum/10;
            int leftover = sum%10;
            curr.val = leftover;
            l1 = l1.next;
        }

        while(l2 != null) {
            curr.next = new ListNode();
            curr = curr.next;
            int sum = carry + l2.val;
            carry = sum/10;
            int leftover = sum%10;
            curr.val = leftover;
            l2 = l2.next;
        }

        if(carry != 0) {
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = carry;
        }

        return res.next;
    }
}