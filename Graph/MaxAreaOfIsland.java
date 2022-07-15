/*
    Time complexity: O(mn)
    Space complexity: O(mn)
    
    Where m, n are the dimensions of the grid
    
    Intuition:
    ----------
    Do a DFS for every non visited '1' keeping track of the area. It'll give us the respective areas of all the connected 1's.
    Return the max area among these.
    
    Problem Link: https://leetcode.com/problems/max-area-of-island/
*/
class Solution {
    private int[] xDir = {0, 1, 0, -1};
    private int[] yDir = {1, 0, -1, 0};
    
    private boolean checkInbounds(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        
        return (row >= 0 && row < m) && (col >= 0 && col < n);
    }
    
    private int dfs(int[][] grid, int row, int col, boolean[][] vis) {
        if (!checkInbounds(grid, row, col))
            return 0;
        
        // mark current cell as visited
        vis[row][col] = true;
        
        // area = 1 because we've found a '1' and we should include it's area.
        int area = 1;
        for(int i = 0; i < 4; i++) {
            int nextRow = row + xDir[i];
            int nextCol = col + yDir[i];
            
            if (checkInbounds(grid, nextRow, nextCol) && grid[nextRow][nextCol] == 1 && !vis[nextRow][nextCol]) {
                area += dfs(grid, nextRow, nextCol, vis);
            }
        }
        
        return area;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        int maxArea = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, vis));
                }
            }
        }
        
        return maxArea;
    }
}
