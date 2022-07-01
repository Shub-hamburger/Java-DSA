/*
    Time complexity: O(M * N) + O(M + N) -> Stack Space.
    Space complexity: O(M * N)
    
    Intuition:
    ---------
    Simple depth first search.
*/

class Solution {
    public boolean checkInbounds(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        
        return (x >= 0 && x < m) && (y >= 0 && y < n);
    }
    
    public void floodFillHelper(int[][] image, int sr, int sc, int color, boolean[][] vis) {
        // base case
        if (!checkInbounds(image, sr, sc))
            return;
        
        // induction
        vis[sr][sc] = true;
        int currColor = image[sr][sc];
        image[sr][sc] = color;
        
        // hypothesis
        // move top
        if (checkInbounds(image, sr, sc - 1) && currColor == image[sr][sc - 1] && !vis[sr][sc - 1])
            floodFillHelper(image, sr, sc - 1, color, vis);
        // move down
        if (checkInbounds(image, sr, sc + 1) && currColor == image[sr][sc + 1] && !vis[sr][sc + 1])
            floodFillHelper(image, sr, sc + 1, color, vis);
        // move right
        if (checkInbounds(image, sr + 1, sc) && currColor == image[sr + 1][sc] && !vis[sr + 1][sc])
            floodFillHelper(image, sr + 1, sc, color, vis);
        // move left
        if (checkInbounds(image, sr - 1, sc) && currColor == image[sr - 1][sc] && !vis[sr - 1][sc])
            floodFillHelper(image, sr - 1, sc, color, vis);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        
        boolean[][] vis = new boolean[m][n];
        
        floodFillHelper(image, sr, sc, color, vis);
        
        return image;
    }
}
