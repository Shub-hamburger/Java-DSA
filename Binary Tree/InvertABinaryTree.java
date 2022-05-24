/*
    Time complexity: O(N)
    Space complexity: O(N)
	
	Problem Link: https://leetcode.com/problems/invert-binary-tree/
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null)
            return null;
        
        // hypothesis
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // induction
        root.left = right;
        root.right = left;
        
        return root;
    }
}
