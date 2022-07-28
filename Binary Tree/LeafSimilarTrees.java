/*
    Time complexity: O(N1 + N2)
    Space complexity: O(N1 + N2)
	
	Problem Link: https://leetcode.com/problems/leaf-similar-trees/
*/
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        // base case
        if (node == null)
            return;
        
        // leaf node
        if (node.left == null && node.right == null)
            leafValues.add(node.val);
        
        // hypothesis
        dfs(node.left, leafValues);
        dfs(node.right, leafValues);
    }
}
