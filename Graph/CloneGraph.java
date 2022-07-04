/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*
    Time complexity: O(n ^ 2) where, n is the number of nodes. 
    This is because for each node we iterate through all its neighbours and in the worst case all
    nodes are connected to each other.
    
    Space complecity: O(n) because we have exactly one map entry for each node and each node gets
    added and removed from the queue exactly once.
    
    Problem Link: https://leetcode.com/problems/clone-graph/
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        // map for storing the clones
        HashMap<Integer, Node> map = new HashMap<>();
        // cloning the root
        map.put(node.val, new Node(node.val));
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node poppedNode = queue.poll();
            
            // iterating over every neighbor node
            for(Node currNode: poppedNode.neighbors) {
                if (!map.containsKey(currNode.val)) {
                    // clone the neighbor
                    map.put(currNode.val, new Node(currNode.val));
                    queue.add(currNode);
                }
                // copy the neighbor
                map.get(poppedNode.val).neighbors.add(map.get(currNode.val));
            }
        }
        
        return map.get(node.val);
    }
}
