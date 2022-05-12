/*
	Time complexity: O(N)
	Space complexity: O(N)
	
	Problem Link: https://www.codingninjas.com/codestudio/problems/893110
*/

class Pair {
    BinaryTreeNode node;
    int level;
    
    public Pair(BinaryTreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class Solution {
    public static Map<Integer, Pair> VerticalTraversal(BinaryTreeNode root, Map<Integer, Pair> map, int level) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, level));
        
        while (!queue.isEmpty()) {
            Pair curr = queue.remove();
            map.put(curr.level, curr);
            
            if (curr.node.left != null) {
                queue.add(new Pair(curr.node.left, curr.level - 1));
            }
            if (curr.node.right != null) {
                queue.add(new Pair(curr.node.right, curr.level + 1));
            }
        }
        return map;
    }
    
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Map<Integer, Pair> map = new TreeMap<>();
        map = VerticalTraversal(root, map, 0);
        
        map.forEach((k, v) -> ans.add(v.node.val));
        return ans;
    }
}
