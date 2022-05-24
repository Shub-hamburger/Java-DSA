/*
    Time complexity: O(N)
    Space complexity: O(N)
	
	Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
*/
class TreeData {
    int height;
    int diameter;
    
    public TreeData(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

class Solution {
    public TreeData diameterHelper(TreeNode root) {
        // base case
        if (root == null) {
            return new TreeData(0, 0);
        }
        
        // hypothesis
        TreeData leftData = diameterHelper(root.left);
        TreeData rightData = diameterHelper(root.right);
        
        // induction
        int height = 1 + Math.max(leftData.height, rightData.height);
        int diameter = leftData.height + rightData.height;
        
        diameter = Math.max(diameter, Math.max(leftData.diameter, rightData.diameter));
        
        return new TreeData(height, diameter);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        TreeData ans = diameterHelper(root);
        return ans.diameter;
    }
}
