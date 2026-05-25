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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index =1;
        ListNode leftHead = head;
        ListNode beforeLeft = null;
        while(index < left) {
            beforeLeft = leftHead;
            leftHead = leftHead.next;
            index++;
        }
        ListNode leftHead2 = leftHead;
        ListNode prev = beforeLeft;
        while(index <= right) {
            ListNode next = leftHead.next;
            leftHead.next = prev;
            prev = leftHead;
            leftHead = next;
            index++;
        }
        if(beforeLeft != null) beforeLeft.next = prev;
        leftHead2.next = leftHead;

        return left != 1 ? head : prev;
    }
}