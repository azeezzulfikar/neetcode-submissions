class Solution {
    public int countComponents(int n, int[][] edges) {
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
                parents[p2] = p1;
                sizes[p1]+=1;
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
