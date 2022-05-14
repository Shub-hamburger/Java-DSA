/*
	Time complexity: O(N)
	Space complexity: O(N) -> Auxiliary Stack Space
	
	Problem Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/
class Solution {
    /*
    // using global variable
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        // base case
        if (root == null)
            return;
        
        // hypothesis
        flatten(root.right);
        flatten(root.left);
        
        // hypothesis
        root.right = prev;
        root.left = null;
        prev = root;
    }
    */
    
    // without using global variable
    private TreeNode helper(TreeNode root, TreeNode prev) {
        // base case
        if(root == null) 
            return prev;
        
        // hypothesis
        prev = helper(root.right, prev);    
        prev = helper(root.left, prev);
        
        // induction
        root.right = prev;
        root.left = null;
        
        return root;
    }
    
    public void flatten(TreeNode root) {
        helper(root, null);
    }
}
