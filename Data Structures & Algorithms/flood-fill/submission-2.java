class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalCol = image[sr][sc];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i < len; i++) {
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];
                for(int[] d: dir) {
                    // should not add to the queue if we are out of bounds or
                    // cell does not have original color
                    // we should not add already visited cell
                    int nr = row + d[0], nc = col + d[1];
                    if(Math.min(nr, nc) < 0 || nr == image.length || nc == image[0].length || image[nr][nc] != originalCol || image[nr][nc] == color)
                        continue;
                    q.offer(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }

        return image;
    }
}