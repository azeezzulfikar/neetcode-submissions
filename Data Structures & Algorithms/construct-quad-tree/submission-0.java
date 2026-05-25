/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        Node root = construct(grid, 0, 0, grid.length, grid[0].length);
        return root;
    }

    private Node construct(int[][] grid, int topRow, int topCol, int bottomRow, int bottomCol) {
        Node root = new Node();
        root.val = grid[topRow][topCol] == 1;
        root.isLeaf = true;
        for(int i=topRow; i< bottomRow; i++) {
            for(int j = topCol; j < bottomCol; j++) {
                if((root.val && grid[i][j] == 1) || (!root.val && grid[i][j] == 0)) continue;
                root.isLeaf = false;
                break;
            }
            if(!root.isLeaf) break;
        }
        if(!root.isLeaf) {
            int midRow = (topRow + bottomRow) / 2;
            int midCol = (topCol + bottomCol) / 2;
            root.topLeft = construct(grid, topRow, topCol, midRow, midCol);
            root.topRight = construct(grid, topRow, midCol, midRow, bottomCol);
            root.bottomLeft = construct(grid, midRow, topCol, bottomRow, midCol);
            root.bottomRight = construct(grid, midRow, midCol, bottomRow, bottomCol);
        }

        return root;
    }
}