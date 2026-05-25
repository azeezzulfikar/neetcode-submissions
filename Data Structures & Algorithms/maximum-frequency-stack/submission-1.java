class FreqStack {
    Stack<Integer> maxInteger;
    Stack<Integer> maxFreqStack;
    Map<Integer, Integer> map;

    public FreqStack() {
        maxInteger = new Stack<>();
        maxFreqStack = new Stack<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int count = map.get(val);
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        while(!maxFreqStack.isEmpty() && maxFreqStack.peek() > count) {
            temp1.push(maxFreqStack.pop());
            temp2.push(maxInteger.pop());
        }
        maxFreqStack.push(count);
        maxInteger.push(val);
        while(!temp1.isEmpty()) {
            maxFreqStack.push(temp1.pop());
            maxInteger.push(temp2.pop());
        }
    }
    
    public int pop() {
        maxFreqStack.pop();
        int num = maxInteger.pop();
        map.put(num, map.get(num) - 1);
        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */