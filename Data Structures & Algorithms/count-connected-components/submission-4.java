class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges.length == 0)
            return n;
        int[] parents = new int[n];
        int[] sizes = new int[n];
        int components = 0;
        for(int i=0; i< n; i++) {
            parents[i] = i;
            sizes[i] = 1;
            components++;
        }
        
        for (int[] edge: edges) {
            int p1 = findParent(edge[0], parents), p2 = findParent(edge[1], parents);
            if(p1!=p2) {
                components--;
                if(sizes[p2] > sizes[p1]) {
                    parents[p1] = p2;
                    sizes[p2]+=1;
                } else {
                    parents[p2] = p1;
                    sizes[p1]+=1;
                }
            }
        }

        return components;
    }

    private int findParent(int node, int[] parents) {
        if(parents[node] != node) {
            return findParent(parents[node], parents);
        }

        return node;
    }
}
