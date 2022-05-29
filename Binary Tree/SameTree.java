/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/same-tree/
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        if (p == null && q == null)
            return true;
        else if (p != null && q == null)
            return false;
        else if (p == null && q != null)
            return false;
        
        // hypothesis
        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);
        
        // induction
        return p.val == q.val && isLeftSame && isRightSame;
    }
}
