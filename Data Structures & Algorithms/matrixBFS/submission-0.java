class Solution {
    public int shortestPath(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        int length = 0;
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i < len; i++) {
                int[] cell = q.pop();
                int row = cell[0], col = cell[1];
                if(row == N -1 && col == M -1)
                    return length;
                for(int[] d: dir) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if(Math.min(nr, nc) < 0 || nr == N || nc == M || visited[nr][nc] || grid[nr][nc] == 1)
                        continue;
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            length++;
        }

        return -1;
    }
}
