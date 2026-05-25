class Solution {
    public int[] getOrder(int[][] tasks) {
        // first sort the tasks using enqueue time
        // next while popping each element from the above queue. Creat a second queue and add the pop element.
        // add the index value to the result, pop elements from the first queue until curr item processing item becomes 0
        // return the result
        int n = tasks.length;
        int[] result = new int[n];
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int i=0; i < n; i++) {
            minHeap.offer(new int[]{i, tasks[i][0], tasks[i][1]});
        }
        int resIndx = 0;
        PriorityQueue<int[]> minHeap2 = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[0], b[0]);
        });
        
        long currentTime = 0;
        while (resIndx < n) {
            if (minHeap2.isEmpty() && !minHeap.isEmpty()) {
                currentTime = Math.max(currentTime, (long)minHeap.peek()[1]);
            }
            
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= currentTime) {
                minHeap2.offer(minHeap.poll());
            }
            
            if (!minHeap2.isEmpty()) {
                int[] task = minHeap2.poll();
                result[resIndx++] = task[0];
                currentTime += task[2];
            }
        }

        return result;
    }
}