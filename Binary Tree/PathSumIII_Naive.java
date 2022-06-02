/*
    Time complexity: O(N ^ 2)
    Space complexity: O(N)
*/
class Solution {
    public int helper(TreeNode root, int current, int target) {
        // base case
        if(root == null)
            return 0;
        
        current += root.val;
        
        // hypothesis
        int left = helper(root.left, current, target);
        int right = helper(root.right, current, target);
        
        // induction
        return (current == target ? 1 : 0) + left + right;
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        // base case
        if(root == null)
            return 0;
        
        int ans = helper(root, 0, targetSum);
        
        // hypothesis
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);
        
        // induction
        return ans + left + right;
    }
}
