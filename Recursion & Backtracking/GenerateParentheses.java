/*
    Time complexity: O((4^n)/sqrt(n)) -> based on catalan number and stirling approximation
    Space complexity: O((4^n)/sqrt(n))
    
    Inutition:
    ----------
    The idea is that we can start an opening bracket if we still have one (of n) left to place. And we can start a =
    closing bracket if it would not exceed the number of opening brackets.
	
	Problem Link: https://leetcode.com/problems/generate-parentheses/
*/
class Solution {    
    public void backtrack(StringBuilder curr, int open, int close, int n, List<String> ans) {
        // base case
        if (curr.length() == n * 2) {
            ans.add(curr.toString());
            return;
        }
        
        // hypothesis
        if (open < n) {
            curr.append("(");
            backtrack(curr, open + 1, close, n, ans);
            
            // backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < open) {
            curr.append(")");
            backtrack(curr, open, close + 1, n, ans);
            
            // backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        backtrack(sb, 0, 0, n, ans);
        return ans;
    }
}
