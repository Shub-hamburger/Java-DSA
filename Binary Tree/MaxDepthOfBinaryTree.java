/*
    Time complexity: O(N)
    Space complexity: O(N) -> Stack Space
	
	Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
*/
class Solution {
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null)
            return 0;
        
        // hypothesis
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // induction
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
