class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

class Deque {

    ListNode left;
    ListNode right;

    public Deque() {
        this.left = new ListNode(-1);
        this.right = new ListNode(-1);
        this.left.next = this.right;
    }

    public boolean isEmpty() {
        return (this.left.next == this.right);
    }

    public void append(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            this.left.next = newNode;
            newNode.next = this.right;
        } else {
            ListNode temp = this.left.next;
            while(temp.next != this.right) {
                temp = temp.next;
            }
            newNode.next = this.right;
            temp.next = newNode;
        }
        System.out.println("append " + value + ": ");
        print();
    }

    public void appendleft(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            this.left.next = newNode;
            newNode.next = this.right;
        } else {
            newNode.next = this.left.next;
            this.left.next = newNode;
        }
        System.out.println("appendLeft " + value + ": ");
        print();
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        ListNode temp = this.left;
        while(temp.next.next != null && temp.next.next != this.right) {
            temp = temp.next;
        }
        int value = temp.next.val;
        temp.next = this.right;
        System.out.println("pop " + value + ": ");
        print();
        return value;
        
    }

    public int popleft() {
        if(isEmpty())
            return -1;
        
        int value = this.left.next.val;
        this.left.next = this.left.next.next;
        System.out.println("popLeft " + value + ": ");
        print();
        return value;
        
    }

    private void print() {
        ListNode temp = this.left;
        while(temp != this.right) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print(this.right.val);
        System.out.println();
    }
}
