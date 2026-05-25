class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones) {
            minHeap.offer(num);
        }

        while(minHeap.size() > 1) {
            int y = minHeap.poll();
            int x = minHeap.poll();
            if(x < y) minHeap.offer(y-x);
        }

        return !minHeap.isEmpty() ? minHeap.peek() : 0;
    }
}
