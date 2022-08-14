/*
    Time complexity: O(rows * cols)
    Space complexity: O(rows * cols)
    
    Problem Link: https://leetcode.com/problems/rotting-oranges/
*/
class Solution {
    int[] xDir = {0, 0, 1, -1};
    int[] yDir = {1, -1, 0, 0};
    
    public boolean checkInbounds(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        
        return (row >= 0 && row < m) && (col >= 0 && col < n);
    }
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int freshOranges = 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        // Count fresh oranges and add rotten ones to queue for BFS
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        
        // BFS on all the rotten oranges.
        while (!queue.isEmpty() && freshOranges > 0) {
            // update time for every level
            time++;
            
            // Do BFS on oranges on current level
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                int[] poppedState = queue.poll();
                int currRow = poppedState[0];
                int currCol = poppedState[1];

                for(int i = 0; i < 4; i++) {
                    int row = currRow + xDir[i];
                    int col = currCol + yDir[i];
                    
                    // check for fresh oranges that are inbounds and rot them.
                    if (checkInbounds(grid, row, col) && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        freshOranges -= 1;
                        queue.add(new int[] {row, col});
                    }
                }
            }
        }
        
        
        return freshOranges == 0 ? time : -1;
    }
}
