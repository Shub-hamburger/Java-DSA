/*
	Time Complexity: O(V + E)
	Space Complexity: O(V + E) + O(V) + O(V) -> adj list + vis array + auxiliary stack space
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118511/offering/1381539
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {	
	public static boolean isBipartiteDFS(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {
		if (color[node] == -1)
			color[node] = 1;
		for(Integer child: adj.get(node)) {
			if (color[child] == -1) {
				color[child] = 1 - color[node];
				if (!isBipartiteDFS(child, adj, color))
					return false;
			}
			else if (color[child] == color[node])
				return false;
		}
		
		return true;
	}
	
	public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int V) {
		int[] color = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			color[i] = -1;
		}
		
		for(int i = 1; i <= V; i++) {
			if (color[i] == -1) {
				if (!isBipartiteDFS(i, adj, color))
					return false;
			}
		}
		
		return true;
	}

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		//adjacency list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i <= V; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			adj.add(list);
		}

		//add edges to list
		for(int i = 0; i < E; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		 
		if(isBipartite(adj, V))
			System.out.println("YES");
		else {
			System.out.println("NO");
		}
    }
}
