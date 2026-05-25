class Solution {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new int[grid.length][grid[0].length]);

    }

    private int dfs(int[][] grid, int row, int col, int[][] visitedNodes) {
        int rowLen = grid.length, colLen = grid[0].length;
        // base cases for invalid
        if(Math.min(row, col) < 0 || row == rowLen || col == colLen || grid[row][col] == 1 || visitedNodes[row][col] == 1)
            return 0;
        if(row == rowLen -1 && col == colLen -1)
            return 1;


        // logic for valid
        int count = 0;
        visitedNodes[row][col] = 1;
        count+=dfs(grid, row+1, col, visitedNodes);
        count+=dfs(grid, row-1, col, visitedNodes);
        count+=dfs(grid, row, col-1, visitedNodes);
        count+=dfs(grid, row, col+1, visitedNodes);
        visitedNodes[row][col] = 0;


        // return what you are expecting
        return count;
    }
}
