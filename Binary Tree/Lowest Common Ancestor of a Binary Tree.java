/*
    Time complexity: O(N)
    Space complexity: O(N) -> Stack space
    
    Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null)
            return null;
        
        if (root.val == p.val || root.val == q.val)
            return root;
        
        // hypothesis
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // induction
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
