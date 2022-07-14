/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Intuition:
    ----------
    The two key observations are:
        1. Preorder traversal follows Root -> Left -> Right, therefore, given the preorder array preorder, we have easy access to
        the root which is preorder[0].
        2. Inorder traversal follows Left -> Root -> Right, therefore if we know the position of Root, we can recursively split
        the entire array into two subtrees.
*/
class Solution {
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        // base case - if there are no elements to construct the tree
        if (inStart > inEnd)
            return null;
        
        // create root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // searching for root in inorder
        int inIdx = map.get(rootVal);
        
        // hypothesis
        // (inIdx - inStart) is basically the no. of left subtree nodes
        TreeNode left = helper(preorder, preStart + 1, preStart + (inIdx - inStart), inorder, inStart, inIdx - 1, map); 
        TreeNode right = helper(preorder, preStart + (inIdx - inStart) + 1, preEnd, inorder, inIdx + 1, inEnd, map);
        
        // induction
        root.left = left;
        root.right = right;
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int preStart = 0;
        int preEnd = preorder.length - 1;
        
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return helper(preorder, preStart, preEnd, inorder, inStart, inEnd, inorderIndexMap);
    }
}
