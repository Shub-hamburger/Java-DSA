/*
    BFS Solution
    ------------
    Time: O(M * N), where M is number of rows, N is number of columns in the matrix.
    Space: O(M * N), space for the queue
    
    Intuition:
    ---------
    Same idea as Topology Sort, we process zero-cells first, then we use queue data structure to keep the order of
    processing cells, so that cells which have the smaller distance will be processed first. 
    Then we expand the unprocessed neighbors of the current processing cell and push into our queue.
    
    Problem Link: https://leetcode.com/problems/01-matrix/
*/

class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new LinkedList<>();
        
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (mat[r][c] == 0) q.add(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i], nc = c + DIR[i + 1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return mat;
    }
}
