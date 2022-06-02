/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/path-sum-ii/
*/
class Solution {
    public void pathSumHelper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> pathList) {
        // base case 
        if (root == null) {
            return;
        }
        
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            pathList.add(new ArrayList<>(path));
        }
        
        // hypothesis
        pathSumHelper(root.left, targetSum - root.val, path, pathList);
        pathSumHelper(root.right, targetSum - root.val, path, pathList);
        
        // induction
        path.remove(path.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumHelper(root, targetSum, path, pathList);
        return pathList;
    }
}
