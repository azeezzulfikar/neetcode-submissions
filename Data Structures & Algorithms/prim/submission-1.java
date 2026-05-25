class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(List<Integer> edge: edges) {
            adjList.computeIfAbsent(edge.get(0), x -> new ArrayList<>()).add(new int[]{edge.get(1), edge.get(2)});
            adjList.computeIfAbsent(edge.get(1), x -> new ArrayList<>()).add(new int[]{edge.get(0), edge.get(2)});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {0, 0});
        int totalWeight = 0;

        while(!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            if(visited.add(node[1])) {
                totalWeight+=node[0];
                for(int[] adj: adjList.get(node[1])) {
                    minHeap.offer(new int[]{adj[1], adj[0]});
                }
            }
        }


        return (totalWeight == 0 || visited.size() != n) ? -1 : totalWeight;
    }
}    
