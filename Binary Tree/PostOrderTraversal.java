/*
    Time complexity: O(N)
    Space complexity: O(N)
	
	Problem Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
*/
class Solution {
    public void postorder(TreeNode root, List<Integer> ans) {
        // base case
        if (root == null)
            return;
        
        // hypothesis
        postorder(root.left, ans);
        postorder(root.right, ans);
        
        // induction
        ans.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        
        return ans;
    }
}
