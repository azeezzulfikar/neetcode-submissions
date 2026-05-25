/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        if(head == null) return null;
        Node newHead = null;
        Node curr = head;
        if(head != null) {
            newHead = new Node(head.val);
            oldToNew.put(head, newHead);
        }
        Node newCurr = newHead;
        while(curr.next != null) {
            newCurr.next = new Node(curr.next.val);
            oldToNew.put(curr.next, newCurr.next);
            newCurr = newCurr.next;
            curr = curr.next;
        }
        curr = head;
        newCurr = newHead;
        while(curr != null) {
            newCurr.random = oldToNew.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}
