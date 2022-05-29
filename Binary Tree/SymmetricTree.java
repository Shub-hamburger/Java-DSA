/*
    Time complexity: O(N)
    Space complexity: O(N)
*/
class Solution {
    public boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {
        // base case
        if (node1 == null && node2 == null)
            return true;
        else if (node1 != null && node2 == null)
            return false;
        else if (node1 == null && node2 != null)
            return false;
        
        // hypothesis
        boolean checkLeft = isSymmetricHelper(node1.left, node2.right);
        boolean checkRight = isSymmetricHelper(node1.right, node2.left);
        
        // induction
        return node1.val == node2.val && checkLeft && checkRight;
    }
    
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }
}
