class KthLargest {
    PriorityQueue<Integer> heap;
    int maxSize;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        maxSize = k;
        for(int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size()> maxSize) heap.poll();
        return heap.peek();
    }
}
