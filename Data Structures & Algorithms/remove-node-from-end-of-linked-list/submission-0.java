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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        
        ListNode prevNode = new ListNode();
        prevNode.next = head;
        ListNode curr = prevNode;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        list.add(null);
        int size = list.size() - 1;
        list.get(size - n - 1).next = list.get(size - n + 1);
        list.remove(list.size() - 1);
        return prevNode.next;
    }
}