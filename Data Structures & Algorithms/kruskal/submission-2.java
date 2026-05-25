class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(2)));
        for(List<Integer> edge: edges) {
            minHeap.offer(edge);
        }

        UnionFind union = new UnionFind(n);
        int len = 0;
        while(!minHeap.isEmpty()) {
            List<Integer> edge = minHeap.poll();
            if(union.union(edge.get(0), edge.get(1))) {
                len+=edge.get(2);
            }
        }

        return union.getCount() == 1 ? len : -1;
    }
}

class UnionFind {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> rank;
    int count;

    public UnionFind(int n) {
        count = n;
        parent = new HashMap<>();
        rank = new HashMap<>();
        for(int i=0; i< n; i++) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    public int find(int x) {
        while(x != parent.get(x)) {
            parent.put(x, parent.get(parent.get(x)));
            x = parent.get(x);
        }

        return x;
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        if(p1 == p2)
            return false;
        if(rank.get(p1) > rank.get(p2)) 
            parent.put(p2, p1);
        else if(rank.get(p2) > rank.get(p1))
            parent.put(p1, p2);
        else {
            parent.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }

        count--;

        return true;
    }

    public int getCount() {
        return count;
    }
}
