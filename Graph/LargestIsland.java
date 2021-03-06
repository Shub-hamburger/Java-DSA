/*
	Time Complexity: O(m * n)
	Space Complexity: O(m * n)
        
        Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118511/offering/1381537
*/

public class Solution {
	public static boolean isSafe(int grid[][], int row, int col, int n, int m, boolean vis[][]) {
                return (row >= 0) && (row < n) && (col >= 0) && (col < m) &&  (grid[row][col] == 1 && !vis[row][col]);
        }
	
	public static int areaDFS(int row, int col, int n, int m, boolean[][] vis, int[][] grid) {
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
                int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
 
                // Mark this cell as visited
                vis[row][col] = true;

                int area = 1;
                // Recur for all connected neighbours
                for (int i = 0; i < 8; i++) {
                        if (isSafe(grid, row + rowNbr[i], col + colNbr[i], n, m, vis))
                            area += areaDFS(row + rowNbr[i], col + colNbr[i], n, m, vis, grid);
                }
		
		return area;
	}
	
	public static int maxAreaOfIsland(int[][] grid, int n, int m) {
		// Write your code here.
		boolean[][] vis = new boolean[n][m];
		int maxArea = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (!vis[i][j] && grid[i][j] == 1) {
					int area = areaDFS(i, j, n, m, vis, grid);
					maxArea = Math.max(maxArea, area);
				}
			}
		}
		
		return maxArea;
	}
}
