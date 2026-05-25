class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i< n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();

        List<Integer> res = new ArrayList<>();
        for(int key: adjList.keySet())
            dfs(visited, path, adjList, key, res);
        Collections.reverse(res);
        return res;

    }

    private void dfs(Set<Integer> visited, Set<Integer> path, Map<Integer, List<Integer>> adjList, int node, List<Integer> res) {
        if(path.contains(node)) {
            res = new ArrayList<>();
            return;
        }
    
        if(visited.contains(node)) {
            return;
        }
        path.add(node);
        for(int adj: adjList.get(node)) {
            dfs(visited, path, adjList, adj, res);
            if(res.isEmpty()) {
                return;
            }
        }
        visited.add(node);
        path.remove(node);
        res.add(node);
    }
}
