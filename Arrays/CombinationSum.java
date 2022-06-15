/*
    Time complexity: (2 ^ target) * k; where k is the average length of the combination. 
    2 ^ target because suppose target = 10 and we  have arr[i] = 1, then we have the option to pick it 10 times!
    
    Space complexity: k * c; where c is the no. of combinations.
*/
class Solution {
    public void combinationSumHelper(int[] candidates, int idx, int n, int target, List<Integer> currAns, List<List<Integer>> ans) {
        // base case
        if (target == 0) {
            ans.add(currAns);
            return;
        } else if (target < 0) {
            return;
        } else if (idx == n && target != 0) {
            return;
        }
        
        // induction
        List<Integer> excludingCurrent = new ArrayList<>(currAns);
        currAns.add(candidates[idx]);
        
        // hypothesis
        combinationSumHelper(candidates, idx, n, target - candidates[idx], currAns, ans);
        combinationSumHelper(candidates, idx + 1, n, target, excludingCurrent, ans);
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        
        combinationSumHelper(candidates, 0, n, target, currAns, ans);
        return ans;
    }
}
