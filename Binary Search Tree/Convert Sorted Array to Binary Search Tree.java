/*
	Time complexity: O(N)
	Space complexity: O(N) -> Auxiliary Stack Space
	
	Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/

class Solution {
    public TreeNode constructTree(int[] nums, int start, int end) {
        // base case
        if (start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        // hypothesis
        TreeNode left = constructTree(nums, start, mid - 1);
        TreeNode right = constructTree(nums, mid + 1, end);
        
        // induction
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        return constructTree(nums, start, end);
    }
}
