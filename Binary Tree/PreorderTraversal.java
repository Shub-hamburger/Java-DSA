/*
    Time complexity: O(N)
    Space complexity: O(N)
	
	Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
*/
class Solution {
    public void preorder(TreeNode root, List<Integer> ans) {
        // base case
        if (root == null)
            return;
        
        // induction
        ans.add(root.val);
        
        // hypothesis
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        
        return ans;
    }
}
