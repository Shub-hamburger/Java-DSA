/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Idea
    ----
    Given we have a route:
    ·················sum(a,b)···········sum(b,c)
    a-------------b--------------c

    we know that, sum(a,c) = sum(a,b) + sum(b,c)
    if target == sum(b,c), then sum(a,c) = sum(a,b) + target

    Now, we could infer that,
    if exists a point b, that conforming sum(a,b) = sum(a,c) - target,
    the, b---c is the path we want to find.
*/
class Solution {
    public int pathSumHelper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> map) {
        // base case
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int count = 0;
        
        count += map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        // hypothesis
        count += pathSumHelper(root.left, currSum, target, map);
        count += pathSumHelper(root.right, currSum, target, map);
        
        // induction
        // Backtracking -> Restore the map, as the recursion goes from the bottom to the top
        map.put(currSum, map.get(currSum) - 1); 
        return count;
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        return pathSumHelper(root, 0, targetSum, map);
    }
}
