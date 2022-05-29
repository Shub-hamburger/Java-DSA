/*
    Time complexity: O(m * n)
    Space complexity: O(m)
    
    where, m is the #nodes in root and n is the #nodes in subRoot
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        
        // hypothesis
        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);
        
        // induction
        return p.val == q.val && isLeftSame && isRightSame;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // base case
        if (root == null)
            return false;
        
        // hypothesis
        if (isSameTree(root, subRoot))
            return true;
        
        // induction
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
