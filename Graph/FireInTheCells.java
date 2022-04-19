/*

    Time Complexity: O(N*M)
    Space Complexity: O(N*M)

    Where N is the number of rows and M is the number of columns in the given matrix.
    
    Problem: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118511/offering/1381540

 */
import java.util.*;
public class Solution {
    private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	// check for inbound
    private static boolean isValid(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
 	
	// check for edge cells
    private static boolean isEdge(int x, int y, int n, int m) {
		if ((x == 0 && y == 0) || (x == n - 1 && y == m - 1) || 
		   (x == 0 && y == m - 1) || (x == n - 1 && y == 0))
			return false;
        return (x == 0 || x == n - 1 || y == 0 || y == m - 1);
    }
	
	public static int fireInTheCells(int[][] mat, int N, int M, int X, int Y) {
		Queue<int[]> fire = new LinkedList<>();
		Queue<int[]> move = new LinkedList<>();
		boolean[][] vis = new boolean[N][M];
		int time = 0;
		
		// add all fired up cells in fire queue
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (mat[i][j] == 0)
					fire.add(new int[]{i, j});
			}
		}
		
		// check for grid's edge case, otherwise add person's init pos to move queue
		if (isEdge(X, Y, N, M))
			return 0;
		// if person is standing on a burning cell 
		if (mat[X][Y] == 0)
			return -1;
		move.add(new int[] {X, Y});
		
		// while movement is possible
		while (!move.isEmpty()) {
			time++;
			
			// add all adjacent safe cells of person to move queue 
			for(int i = 0; i < move.size(); i++) {
				int[] pos = move.poll();
				
				// if curr cell is on fire, don't go there
				if (mat[pos[0]][pos[1]] == 0)
					continue;
				
				for(int k = 0; k < 4; k++) {
					int x = pos[0] + dir[k][0];
					int y = pos[1] + dir[k][1];
					
					// if curr cell is valid, not on fire and not visited yet
					if (isValid(x, y, N, M) && mat[x][y] != 0 && !vis[x][y]) {
						vis[x][y] = true;
						move.add(new int[] {x, y});
						
						// check if person reached edge of grid
						if (isEdge(x, y, N, M))
							return time;
					}
				}
			}
			
			// burn all the adjacent edges 
			for(int j = 0; j < fire.size(); j++) {
				int[] pos = fire.poll();
				
				for(int k = 0; k < 4; k++) {
					int x = pos[0] + dir[k][0];
					int y = pos[1] + dir[k][1];
					
					// if curr cell is valid, not on fire
					if (isValid(x, y, N, M) && mat[x][y] != 0) {
						mat[x][y] = 0;
						fire.add(new int[] {x, y});
					}
				}
			}
		}
		
		return -1;
	}
}
