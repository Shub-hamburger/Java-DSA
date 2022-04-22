/*
    Time Complexity: O(V+E)
    Space complexity: O(V)
    
    Where V is the number of vertices and E is the number of edges in graph.
    
    Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118511/offering/1381541
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int bfs(ArrayList<ArrayList<Integer>> graph, boolean marked[], int u, int[] distances) {
        int preMarked = 0;
        Queue<Integer> queue = new LinkedList<Integer>();

        // Push node u in queue and initialize its distance as 0
        queue.add(u);

        distances[u] = 0;

        // Loop until all nodes are processed
        while (!queue.isEmpty()) {
            u = queue.poll();
            // If node is marked, update preMarked variable
            if (marked[u])
                preMarked = u;

            // Loop over all neighbors of u and update their
            // Distance before pushing in queue
            for (int i = 0; i < graph.get(u).size(); i++) {
                int v = graph.get(u).get(i);

                // If not given value already
                if (distances[v] == -1) {
                    distances[v] = distances[u] + 1;
                    queue.add(v);
                }
            }
        }
        // Return previous updated marked value
        return preMarked;
    }

    // Function returns count of nodes which are in k-distance
    // Range from marked nodes
    public static int nodesWithinKDistance(int[][] edges, int v, int marked[], int m, int k) {

        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < v; i++) {
            g.add(new ArrayList<Integer>());
        }
        // Prepare the graph
        int u1, v1;
        for (int i = 0; i < (v - 1); i++) {
            u1 = edges[i][0] - 1;
            v1 = edges[i][1] - 1;

            g.get(u1).add(v1);
            g.get(v1).add(u1);
        }

        // Fill boolean array mark from marked array
        boolean[] mark = new boolean[v];
        // As the index is one based
        for (int i = 0; i < m; i++) {
            marked[i] = marked[i] - 1;
        }
        for (int i = 0; i < m; i++) {
            mark[marked[i]] = true;
        }

        // Arrays to store distances from extremes
        int[] temp = new int[v];
        int[] distanceFromFirstExtreme = new int[v];
        int[] distanceFromSecondExtreme = new int[v];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = -1;
        }
        for (int j = 0; j < temp.length; j++) {
            distanceFromFirstExtreme[j] = -1;
        }

        for (int j = 0; j < temp.length; j++) {
            distanceFromSecondExtreme[j] = -1;
        }
        // First bfs from any random node to get first extreme marked node

        u1 = bfs(g, mark, 0, temp);

        // Second bfs to get other extreme marked node
        // And also distanceFromFirstExtreme is filled with distances from first
        // extreme
        // Chosen marked node
        v1 = bfs(g, mark, u1, distanceFromFirstExtreme);

        // Third bfs to fill distanceFromSecondExtreme by distances from second
        // extreme
        // Chosen marked node
        bfs(g, mark, v1, distanceFromSecondExtreme);

        int count = 0;
        // Loop over all nodes
        for (int i = 0; i < v; i++) {
            // Increase count by 1, if current node has distance
            // Less than k from both extreme nodes
            if (distanceFromFirstExtreme[i] <= k && distanceFromSecondExtreme[i] <= k)
                count++;
        }
        return count;
    }
}

