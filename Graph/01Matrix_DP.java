/*
    DP Solution
    -----------
    Time: O(M * N), where M is number of rows, N is number of columns in the matrix.
    Space: O(1)
    
    Intuition:
    ----------
    In this problem, a cell has at most 4 neighbors that are left, top, right, bottom. If we use dynamic programming to
    compute the distance of the current cell based on 4 neighbors simultaneously, it's impossible because we are not
    sure if distance of neighboring cells is already computed or not.

    That's why, we need to compute the distance one by one:
        1. Firstly, for a cell, we restrict it to only 2 directions which are left and top. Then we iterate cells from
        top to bottom, and from left to right, we calculate the distance of a cell based on its left and top neighbors.
        2. Secondly, for a cell, we restrict it only have 2 directions which are right and bottom. Then we iterate cells
        from bottom to top, and from right to left, we update the distance of a cell based on its right and bottom
        neighbors.
*/

class Solution { 
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length, INF = m + n; // The distance of cells is up to (M + N)
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) continue;
                int top = INF, left = INF;
                if (r - 1 >= 0) top = mat[r - 1][c];
                if (c - 1 >= 0) left = mat[r][c - 1];
                mat[r][c] = Math.min(top, left) + 1;
            }
        }
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] == 0) continue;
                int bottom = INF, right = INF;
                if (r + 1 < m) bottom = mat[r + 1][c];
                if (c + 1 < n) right = mat[r][c + 1];
                mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}
