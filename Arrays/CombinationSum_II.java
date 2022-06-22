/*
    Time complexity: O(2 ^ N)
    Space complexity: O(N) -> Array creation + O(N) -> Stack space
    
    Problem Link: https://leetcode.com/problems/combination-sum-ii/
*/

class Solution {
    public void combinationSumHelper(int[] candidates, int idx, int target, 
                                                    List<Integer> currAns, List<List<Integer>> ans) {
        // base case
        if (target == 0) {
            ans.add(currAns);
            return;
        } else if (target < 0) {
            return;
        } else if (idx == candidates.length && target != 0) {
            return;
        }
        
        // induction
        List<Integer> excludingCurrent = new ArrayList<>(currAns);
        
        if (candidates[idx] <= target) {
            currAns.add(candidates[idx]);
            
            // hypothesis - including current element
            combinationSumHelper(candidates, idx + 1, target - candidates[idx], currAns, ans);
        }
        
        // Skip duplicates
        while (idx < candidates.length - 1 && candidates[idx] == candidates[idx + 1])
            idx++;
        
        // hypothesis - excluding current element
        combinationSumHelper(candidates, idx + 1, target, excludingCurrent, ans);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort candidates - to bring duplicates together
        Arrays.sort(candidates);
        
        List<Integer> currAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        combinationSumHelper(candidates, 0, target, currAns, ans);
        
        return ans;
    }
}
