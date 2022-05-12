/*
	Time complexity: O(N)
	Space complexity: O(N)
	
	Problem Link: https://www.codingninjas.com/codestudio/problems/920519
*/
import java.util.*;

public class Solution {
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        //    Write your code here.
		ArrayList<Integer> ans = new ArrayList<>();
		boolean first = true;
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		
		if (root == null)
			return ans;
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			first = true;
			
			for(int i = 0; i < n; i++) {
				TreeNode<Integer> curr = queue.poll();
				if (first) {
					ans.add(curr.data);
					first = false;
				}
				
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
		}
		
		return ans;
    }
}
