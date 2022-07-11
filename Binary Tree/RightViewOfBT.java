/*
	Time complexity: O(N)
	Space complexity: O(N)
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean addToQueue;
        while (!queue.isEmpty()) {
            addToQueue = true;
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (addToQueue) {
                    ans.add(curr.val);
                    addToQueue = false;
                }
                
                if (curr.right != null)
                    queue.add(curr.right);
                if (curr.left != null)
                    queue.add(curr.left);
            }
        }
        
        return ans;
    }
}
