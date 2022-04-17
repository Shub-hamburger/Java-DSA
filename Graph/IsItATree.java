/*
	Time Complexity: O(V + E) + O(V)
	Space Complexity: O(V + E) + O(V) + O(V) -> adj list + vis array + auxiliary stack space
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118511/offering/1381534
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static boolean checkForCycle(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
		vis[node] = true;
		for(Integer child: adj.get(node)) {
			if (!vis[child]) {
				if (checkForCycle(child, node, vis, adj)) 
					return true;
			}
			else if (child != parent) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isTree(ArrayList<ArrayList<Integer>> adj, int V) {
	    boolean[] vis = new boolean[V];
		if (checkForCycle(0, -1, vis, adj))
			return false;
		
		for(int i = 0; i < V; i++) {
			if (!vis[i])
				return false;
		}
		
		return true;
	}

    // Do not change this part of the code. You only need to complete the isTree function above.
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		//adjacency list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i =0; i<V; i++) {
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

		if(isTree(adj, V))
			System.out.println("True");
		else {
			System.out.println("False");
		}
	}

}
