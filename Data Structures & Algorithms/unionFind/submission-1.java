class UnionFind {

    int[] sets;
    int[] ranks;
    int components;

    public UnionFind(int n) {
        components = n;
        sets = new int[n];
        ranks = new int[n];
        for(int i=0; i< n; i++) {
            sets[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x) {
        if(x != sets[x])
            return find(sets[x]);
        return sets[x];
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if(p1 == p2)
            return false;
        if(ranks[p1] < ranks[p2]) {
            sets[p1] = p2;
            ranks[p2] += ranks[p1];
        } else {
            sets[p2] = p1;
            ranks[p1] += ranks[p2];
        }
        components--;
        return true;
    }

    public int getNumComponents() {
        return components;
    }
}
