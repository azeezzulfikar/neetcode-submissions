class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
    public Node() {
        this.val = -1;
    }
}
class MyCircularQueue {
    Node head;
    Node tail;
    int capacity;
    int currSize;

    public MyCircularQueue(int k) {
        capacity = k;
        currSize = 0;
        head = new Node();
        int len = 1;
        Node curr = head;
        while(len < k) {
            curr.next = new Node();
            curr = curr.next;
            len++;
        }
        curr.next = head;
        tail = head;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(!isEmpty()) tail = tail.next;
        tail.val = value;
        currSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        head.val = -1;
        currSize--;
        if(!isEmpty()) head = head.next;
        return true;
    }
    
    public int Front() {
        return head.val;
    }
    
    public int Rear() {
        return tail.val;
    }
    
    public boolean isEmpty() {
        return currSize == 0;
    }
    
    public boolean isFull() {
        return capacity == currSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */