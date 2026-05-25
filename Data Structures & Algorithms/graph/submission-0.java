class Graph {

    Map<Integer, Set<Integer>> paths;

    public Graph() {
        paths  = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if(!paths.containsKey(src)) {
            paths.put(src, new HashSet<>());
        }
        if(!paths.containsKey(dst)) {
            paths.put(dst, new HashSet<>());
        }
        paths.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(paths.containsKey(src)) {
            return paths.get(src).remove(dst);    
        }

        return false;
    }

    public boolean hasPath(int src, int dst) {
        if(paths.containsKey(src)) {
            Queue<Integer> q = new ArrayDeque<>();
            q.add(src);
            while(!q.isEmpty()) {
                int key = q.poll();
                if(dst == key)
                    return true;
                for(int dsts: paths.get(key)) {
                    if(dsts == dst)
                        return true;
                    q.offer(dsts);
                }
            }    
        }

        return false;

    }
}
