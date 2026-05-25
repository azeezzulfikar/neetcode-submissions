class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt((a) -> a[0]));

        for(int key: map.keySet()) {
            minHeap.offer(new int[]{map.get(key), key});
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()) {
            res[index] = minHeap.poll()[1];
            index++;
        }

        return res;

    }
}