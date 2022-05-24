/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/balanced-binary-tree/
*/
class TreeBalanced {
    int height;
    boolean balanced;
    
    public TreeBalanced(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

class Solution {
    public TreeBalanced isBalancedHelper(TreeNode root) {
        // base case
        if (root == null) {
            return new TreeBalanced(0, true);
        }
        
        // hypothesis
        TreeBalanced leftData = isBalancedHelper(root.left);
        TreeBalanced rightData = isBalancedHelper(root.right);
        
        // induction
        int height = 1 + Math.max(leftData.height, rightData.height);
        if (!leftData.balanced || !rightData.balanced) {
            return new TreeBalanced(height, false);
        }
        if (Math.abs(leftData.height - rightData.height) > 1) {
            return new TreeBalanced(height, false);
        }
        return new TreeBalanced(height, true);
    }
    
    public boolean isBalanced(TreeNode root) {
        TreeBalanced ans = isBalancedHelper(root);
        return ans.balanced;
    }
}
