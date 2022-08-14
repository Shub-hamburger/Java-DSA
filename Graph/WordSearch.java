/*
    Time complexity: O(m * n)
    Space complexity: O(m * n)
    
    where, m & n are the dims of the board.
    
    Intuition:
    ----------
    Simple DFS of the grid. We also backtrack so that we cover all the paths that may form the word.
*/
class Solution {
    public boolean checkInbounds(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        
        return (row >= 0 && row < m) && (col >= 0 && col < n);
    }
    
    public boolean dfs(char[][] board, int idx, String word, int row, int col, boolean[][] vis) {
        // base case
        if (idx == word.length())
            return true;
        if (!checkInbounds(board, row, col) || vis[row][col] || 
            (word.charAt(idx) != board[row][col]))
            return false;
        
        // Set current cell as visited
        vis[row][col] = true;
        
        // hypothesis
        boolean top = dfs(board, idx + 1, word, row, col - 1, vis);
        boolean bottom = dfs(board, idx + 1, word, row, col + 1, vis);
        boolean left = dfs(board, idx + 1, word, row - 1, col, vis);
        boolean right = dfs(board, idx + 1, word, row + 1, col, vis);
        
        // backtrack - unvisit the current cell
        vis[row][col] = false;
        
        // induction
        return  top || bottom || left || right;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        // matrix to track visited cells.
        boolean[][] vis = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // do DFS only if the first letter of the word matches the character in the cell.
                if (board[i][j] == word.charAt(0) && !vis[i][j]) {
                    if(dfs(board, 0, word, i, j, vis))
                        return true;
                }
            }
        }
        return false;
    }
}
