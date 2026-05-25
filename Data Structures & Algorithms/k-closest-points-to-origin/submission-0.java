class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        for(int i=0; i< points.length; i++) {
            minHeap.offer(new int[]{(points[i][0]*points[i][0] + points[i][1] * points[i][1]), i});
            if(minHeap.size() > k) minHeap.poll();
        }
        int[][] res = new int[k][2];
        int index=0;
        while(minHeap.size() > 0) {
            int[] item = minHeap.poll();
            res[index] = points[item[1]];
            index++;
        }

        return res;
    }
}
